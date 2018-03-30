package io.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inventory.model.Inventory;
import io.inventory.model.User;
import io.inventory.repository.InventoryRepository;
import io.inventory.repository.UserRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	private UserRepository userRepository;
	
	public List<Inventory> getAllInventory(String id){
		
		List<Inventory> inventorys = new ArrayList<>();
		
		inventoryRepository.findByUserId(id).forEach(inventorys::add);
		
		return inventorys;
		
	}
	
	public Optional<Inventory> getInventory(Long id) {
		return inventoryRepository.findById(id);
	}

	public void addInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
		
	} 
	public void updateInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}
	
	public void deleteInventory(Long id) {
		inventoryRepository.deleteById(id);;
	}
	public void deleteAllInventorys() {
		inventoryRepository.deleteAll();;
		
	}
	
	
}
