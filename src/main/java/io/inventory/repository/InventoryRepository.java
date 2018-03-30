package io.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.inventory.model.Inventory;
import io.inventory.model.User;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	public List<Inventory> findByUserId(String id);
}
