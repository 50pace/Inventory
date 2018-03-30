package io.inventory.dto;


import io.inventory.model.Item;

public class ItemDTO {
	
	private Long itemId;
	private String name;
	private Integer orderNumber;
	private String category;
	private Long value;
	private String description;
	private Integer barcode;
	
	private Long inventoryDto;
	
	

	public static ItemDTO itemToItemDto(Item item ) {
		if(item == null) {
			return null;
		}else {
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setItemId(item.getItemId());
			itemDTO.setOrderNumber(item.getOrderNumber());
			itemDTO.setInventoryDto(item.getInventory().getId());
			itemDTO.setName(item.getName());
			itemDTO.setOrderNumber(item.getOrderNumber());
			itemDTO.setCategory(item.getCategory());
			itemDTO.setValue(item.getValue());
			itemDTO.setDescription(item.getDescription());
			itemDTO.setBarcode(item.getBarcode());
			return itemDTO;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemIdDto) {
		this.itemId = itemIdDto;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getInventoryDto() {
		return inventoryDto;
	}

	public void setInventoryDto(Long inventoryDto) {
		this.inventoryDto = inventoryDto;
	}
	
	
	
}
