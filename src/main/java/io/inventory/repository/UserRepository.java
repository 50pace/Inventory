package io.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.inventory.model.Item;
import io.inventory.model.User;
//automatski implementira spring u bean
public interface UserRepository extends CrudRepository<User, Long> {
	
}
