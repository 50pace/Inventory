package io.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inventory.model.Item;
import io.inventory.repository.InventoryRepository;
import io.inventory.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	private InventoryRepository inventoryRepository;
	public List<Item> getAllItems(Long id){
		
		List<Item> items = new ArrayList<>();
		itemRepository.findByInventoryId(id).forEach(items::add);
		return items;
		
	}
	public Optional<Item> getItem(Long itemId) {
		return itemRepository.findById(itemId);
	}


	public void addItem(Item item) {
		itemRepository.save(item);
		
	}
	public void updateItem(Item item) {
		itemRepository.save(item);
		
	}

	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}
	
}
