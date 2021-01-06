package com.enic.ondelivery.dto;

import java.io.Serializable;

import com.enic.ondelivery.entities.Product;

//This class is a object to load product data to the upper layer (web)
public class ProductDTO implements Serializable {
	
	//Serializable allows our products can be turned on byte sequences - it is a good practice
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double price;
	private String name;
	private String description;
	private String imgUrl;
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, Double price, String name, String description, String imgUrl) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		price = entity.getPrice();
		name = entity.getName();
		description = entity.getDescription();
		imgUrl = entity.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}