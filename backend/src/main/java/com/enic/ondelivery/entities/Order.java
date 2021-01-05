package com.enic.ondelivery.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //This notation means the products will be entities managed by JPA (and the class Product corresponds to a table in the db)
@Table(name = "tb_order")
public class Order implements Serializable {
	//Serializable allows our products can be turned on byte sequences - it is a good practice
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Ensures that the id will be unique and auto incrementable 
	private Long id;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private String address;
	private OrderStatus status;
	
	//Association many to many to the products list
	@ManyToMany
	@JoinTable(name = "tb_order_product",
		joinColumns = @JoinColumn(name = "order_id"), //Sets the foreign key that references the current class
		inverseJoinColumns = @JoinColumn(name = "product_id")) //Sets the foreign key that references the class product
	private Set<Product> products = new HashSet<>();
	
	public Order() {
	}

	public Order(Long id, Double latitude, Double longitude, Instant moment, String address, OrderStatus status) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.address = address;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Set<Product> getProducts() {
		return products;
	}	
}
