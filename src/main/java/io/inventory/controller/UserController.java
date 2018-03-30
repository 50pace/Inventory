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

import io.inventory.dto.UserDTO;
import io.inventory.model.Inventory;
import io.inventory.model.User;
import io.inventory.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	
		@RequestMapping(method = RequestMethod.GET, value = "")
		public ResponseEntity<List<UserDTO>> getAllUsers(){
			
			List<User> user = userService.getAllUsers();
			
			List<UserDTO> userDTO = new ArrayList<>();
			
			for(User u : user) {
				userDTO.add(UserDTO.UsertoUserDTO(u));	
			}
			
			if(user != null) {
				return new ResponseEntity<List<UserDTO>>(userDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
			}
		}
	
		@RequestMapping (method = RequestMethod.GET , value = "/{id}")
		public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
			
			
			Optional<User> optionalUser = userService.getUser(id);
			
			if(optionalUser.isPresent()) {
				User user = userService.getUser(id).get();
				return new ResponseEntity<UserDTO>(UserDTO.UsertoUserDTO(user), HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
			}
			
			
		}
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<Void> addUser(@RequestBody User user, @PathVariable Long id) {
			userService.addUser(user);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getName()).toUri().toString());
					
		return new ResponseEntity<Void>(httpHeaders , HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/{id}")
	public ResponseEntity<Void> updateUser(@RequestBody User user , @PathVariable Long id) {
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/{id}" )
	public ResponseEntity<Void> deleteUser( @PathVariable Long id) {
			 userService.deleteUser(id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.DELETE , value = "" )
	public ResponseEntity<Void> deleteAllUsers() {
			 userService.deleteAllUsers();
			 return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}
