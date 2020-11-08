package com.zoethacode.pdfgenerator.model;

public class User {
	private String name;
	private String email;
	private float weigth;
	private float height;
	
	public User() {
		super();
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
	public float getWeigth() {
		return weigth;
	}
	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "name=" + name + ", email=" + email + ", weigth=" + weigth + ", height=" + height;
	}
	
	
	
}
