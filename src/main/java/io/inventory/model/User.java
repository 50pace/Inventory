package io.inventory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	//singleton
	private static User instance=null;
	public static User getInstance(){
		 if(instance==null){
		 instance = new User();

		 }
		 return instance;
		 } 

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	 @OneToMany(cascade = CascadeType.ALL,
	    		fetch = FetchType.EAGER,
	    		mappedBy = "user")
	private List<Inventory> listOfInvertories = new ArrayList<>();
	 
    private String name;
    
    private String lastName;
    
    private String password;

    private String email;
   
   

    public User() {
    	
    }
    
	public User(Long id, String name, String lastName, String password, String email, List<Inventory> listOfInvertories) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.listOfInvertories = listOfInvertories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Inventory> getListOfInvertories() {
		return listOfInvertories;
	}

	public void setListOfUsers(List<Inventory> listOfInvertories) {
		this.listOfInvertories = listOfInvertories;
	}


	


}
