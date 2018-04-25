package com.myretail.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class Product {

	@Id
	private Long id;
	private String name;
	private String brand;
	private String modleNumber;
	private String description;
	private Date mfgDate;

	public Product() {

	}

	public Product(Long id, String name, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}

	public Product(Long id, String name, String brand, String modleNumber, String description, Date mfgDate) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.modleNumber = modleNumber;
		this.description = description;
		this.mfgDate = mfgDate;
	}

	public String getModleNumber() {
		return modleNumber;
	}

	public void setModleNumber(String modleNumber) {
		this.modleNumber = modleNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", modleNumber=" + modleNumber
				+ ", description=" + description + ", mfgDate=" + mfgDate + "]";
	}
}
