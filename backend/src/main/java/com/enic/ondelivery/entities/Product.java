package com.enic.ondelivery.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //This notation means the products will be entities managed by JPA (and the class Product corresponds to a table in the db)
@Table(name = "tb_product")
public class Product implements Serializable {
	//Serializable allows our products can be turned on byte sequences - it is a good practice
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Ensures that the id will be unique and auto incrementable 
	private Long id;
	private Double price;
	private String name;
	private String description;
	private String imgUrl;
	
	public Product() {
	}

	public Product(Long id, Double price, String name, String description, String imgUrl) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
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

	public void setImgUrl(String imgURL) {
		this.imgUrl = imgURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}