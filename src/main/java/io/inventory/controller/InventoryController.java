package io.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import io.inventory.dto.InventoryDTO;
import io.inventory.model.Inventory;
import io.inventory.model.Item;
import io.inventory.service.InventoryService;
import io.inventory.service.UserService;

@RequestMapping(value = "/users/{userId}/inventory")
@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private UserService userService;
	
	
		@RequestMapping(method = RequestMethod.GET, value = "")
		public ResponseEntity<List<InventoryDTO>> getAllInventory(@PathVariable String userId){
			
			List<Inventory> inventory = inventoryService.getAllInventory(userId);	
			List<InventoryDTO> inventoryDTO = new ArrayList<>();
			
			for (Inventory i : inventory) {
				
				inventoryDTO.add(InventoryDTO.InventorytoInventoryDto(i));
				
			}
			
			if(inventory == null) {
				
				return new ResponseEntity<List<InventoryDTO>>(HttpStatus.NOT_FOUND);
				
			}else {
				
				return new ResponseEntity<List<InventoryDTO>>(inventoryDTO,  HttpStatus.OK);
				
			}
					
			
		}
		
		
		@RequestMapping (method = RequestMethod.GET , value = "/{id}")
		public ResponseEntity<InventoryDTO> getInventory(@PathVariable long id) {
			
			
			Optional<Inventory> optionalInventory = inventoryService.getInventory(id);
			
			if(optionalInventory.isPresent()) {
				Inventory inventory = inventoryService.getInventory(id).get();
				return new ResponseEntity<InventoryDTO>(InventoryDTO.InventorytoInventoryDto(inventory), HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<InventoryDTO>(HttpStatus.NOT_FOUND);
			}
			
			
		}
		
		
		@RequestMapping(method = RequestMethod.POST, value = "/")
		public ResponseEntity<Void> addInventory(@RequestBody Inventory inventory,@PathVariable Long userId) {
				inventoryService.addInventory(inventory);
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.add("Location", 
								ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inventory.getId()).toUri().toString()
								);
						
			return new ResponseEntity<Void>(httpHeaders , HttpStatus.CREATED);
		}
		
	
		@RequestMapping(method = RequestMethod.PUT , value = "/{id}")
		public ResponseEntity<Void> updateInventory(@RequestBody Inventory inventory , @PathVariable long userId) {
			inventoryService.updateInventory(inventory);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		
		
		@RequestMapping(method = RequestMethod.DELETE , value = "/{id}" )
		public ResponseEntity<Void> deleteInventory( @PathVariable long id) {
				 inventoryService.deleteInventory(id);
				 return new ResponseEntity<Void>(HttpStatus.OK);
			
		}

		@RequestMapping(method = RequestMethod.DELETE , value = "" )
		public ResponseEntity<Void> deleteAllInventorys() {
				 inventoryService.deleteAllInventorys();
				 return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
	
				
}