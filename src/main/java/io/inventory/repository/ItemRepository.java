package io.inventory.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.inventory.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

		public List<Item> findByInventoryId(Long id);
}
