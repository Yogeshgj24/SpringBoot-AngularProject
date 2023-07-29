package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// System.out.println(id+"<=id---itemName=>"+itemName+"quantity=>"+quantity+price+"<=price");

@Entity
@Table
public class MyEntity {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String itemName;
	
	@Column
	private int quantity;
	
	@Column
	private int price;
	
	@Column
	private int grade;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public MyEntity() {
		super();
	}

	public MyEntity(int id, String itemName, int quantity, int price, int grade) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("MyEntity [id=%s, itemName=%s, quantity=%s, price=%s, grade=%s]", id, itemName, quantity, price, grade);
	}
	
	

}
