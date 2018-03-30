package io.inventory.dto;

import java.util.ArrayList;
import java.util.List;

import io.inventory.model.Inventory;
import io.inventory.model.Item;

public class InventoryDTO {
	private Long id;
	private List<Long> itemId = new ArrayList<>();
	private Long userId;
	
	public static InventoryDTO InventorytoInventoryDto(Inventory inventory) {
		
		if(inventory == null) {
			return null;
		}else {
			 
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setId(inventory.getId());
			for (Item i : inventory.getListOfItems()) {	
				inventoryDTO.itemId.add(i.getItemId());	
			}
			
			return inventoryDTO;
		}
	}
	
	public List<Long> getItemId() {
		return itemId;
	}

	public void setItemNames(List<Long> itemNames) {
		this.itemId = itemNames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserID() {
		return userId;
	}

	public void setUserID(Long userID) {
		this.userId = userID;
	}

	public void setItemId(List<Long> itemId) {
		this.itemId = itemId;
	}

	
	
	
}
