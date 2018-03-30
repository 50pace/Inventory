package io.inventory.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CascadeType;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Inventory inventory;
	
	
	private String name;
	private Integer orderNumber;
	private String category;
	private Long value;
	private String description;
	private Integer barcode;
	
	public Item() {
		
	}

	
	public Item(Long itemId, String name, Integer orderNumber, String category, Long value, String description,
			Integer barcode, Inventory inventory) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.orderNumber = orderNumber;
		this.category = category;
		this.value = value;
		this.description = description;
		this.barcode = barcode;
		this.inventory = inventory;
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

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	
}
