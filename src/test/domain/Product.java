package test.domain;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4316534618756633564L;

	private String name;
	private String description;
	private float price;
	private long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setId(Long newId) {
		// TODO Auto-generated method stub
		id = newId;
	}
	public long getId() {
		return id;
	}
	
	
}
