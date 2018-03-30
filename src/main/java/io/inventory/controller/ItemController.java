package io.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileItemStream.ItemSkippedException;
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

import com.mysql.fabric.Response;

import io.inventory.dto.ItemDTO;
import io.inventory.model.Inventory;
import io.inventory.model.Item;
import io.inventory.service.InventoryService;
import io.inventory.service.ItemService;

@RequestMapping(value = "/users/{userId}/inventory/{id}/item")
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(method = RequestMethod.GET , value = "")
	public ResponseEntity <List<ItemDTO>>  getAllItems(@PathVariable Long userId , @PathVariable Long id){
		
		List<Item> items = itemService.getAllItems(id);
		List<ItemDTO> itemsDTO = new ArrayList<>();
		for (Item i : items) {
			
			itemsDTO.add(ItemDTO.itemToItemDto(i));
			
		}
		if(items != null) {
			return new ResponseEntity<List<ItemDTO>>( itemsDTO, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<ItemDTO>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{itemId}")
	public ResponseEntity<ItemDTO> getItem(@PathVariable Long userId, @PathVariable Long id, @PathVariable Long itemId) {
		
		Optional<Item> optionalItem = itemService.getItem(itemId);
		if(optionalItem.isPresent()) {
			Item item =itemService.getItem(itemId).get();
			return new ResponseEntity<ItemDTO> (ItemDTO.itemToItemDto(item),HttpStatus.OK);
		}else {
			return new ResponseEntity<ItemDTO> (HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/")
	public ResponseEntity<Void> addItem(@RequestBody Item item ,@PathVariable Long userId,  @PathVariable Long id) {
		
		itemService.addItem(item);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", 
						ServletUriComponentsBuilder.fromCurrentRequest().path("/{itemId}").buildAndExpand(item.getItemId()).toUri().toString()
						);
		
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{itemId}")
	public ResponseEntity<Void> updateItem(@RequestBody Item item, @PathVariable Long id, @PathVariable Long itemId) {
		itemService.updateItem(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/{itemId}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
		itemService.deleteItem(itemId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
