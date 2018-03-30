package io.inventory.dto;

import java.util.ArrayList;
import java.util.List;

import io.inventory.model.Inventory;
import io.inventory.model.Item;
import io.inventory.model.User;

public class UserDTO {
	private Long id;

    private String name;
    
    private String lastName;
    
    private String password;

    private String email;
    
	private List<Long> invertoryId = new ArrayList<>();
	
	public static UserDTO UsertoUserDTO(User user) {
		if(user == null) {
			return null;
		}else {
			 
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setLastName(user.getLastName());
			userDTO.setPassword(user.getPassword());
			
			for (Inventory i : user.getListOfInvertories()) {
				userDTO.invertoryId.add(i.getId());
			}
			
			return userDTO;
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getInvertoryId() {
		return invertoryId;
	}

	public void setInvertoryId(List<Long> invertoryId) {
		this.invertoryId = invertoryId;
	}
}
