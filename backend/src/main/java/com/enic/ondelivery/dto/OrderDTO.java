package com.enic.ondelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.enic.ondelivery.entities.Order;
import com.enic.ondelivery.entities.OrderStatus;

public class OrderDTO implements Serializable {
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
	
	private List<ProductDTO> products = new ArrayList<>();
	
	public OrderDTO() {
	}

	public OrderDTO(Long id, Double latitude, Double longitude, Instant moment, String address, OrderStatus status) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.address = address;
		this.status = status;
	}
	
	public OrderDTO(Order entity) { //Transforms product in product DTO
		id = entity.getId();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		address = entity.getAddress();
		status = entity.getStatus();
		products = entity.getProducts().stream()
				.map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}
}