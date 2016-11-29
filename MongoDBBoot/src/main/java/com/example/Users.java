package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {
	@Id
	private String id;
	private String name;
	private String CityofBirth;
	public Users(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityofBirth() {
		return CityofBirth;
	}
	public void setCityofBirth(String cityofBirth) {
		CityofBirth = cityofBirth;
	}
	

}
