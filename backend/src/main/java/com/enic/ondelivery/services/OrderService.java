package com.enic.ondelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enic.ondelivery.dto.OrderDTO;
import com.enic.ondelivery.dto.ProductDTO;
import com.enic.ondelivery.entities.Order;
import com.enic.ondelivery.entities.OrderStatus;
import com.enic.ondelivery.entities.Product;
import com.enic.ondelivery.repositories.OrderRepository;
import com.enic.ondelivery.repositories.ProductRepository;

@Service //Makes the class a registered component that can be injected in other components
public class OrderService {
	
	@Autowired //SpringBoot resource to make a dependency injection automatically
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly=true) //Just read cause it's just searching
	public List<OrderDTO> find(){
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); //Lambda expression
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){ //dto contains the order and its data
		Order order = new Order(null, dto.getLatitude(), 
				dto.getLongitude(), Instant.now(), dto.getAddress(), OrderStatus.PENDING);
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId()); //Instance a new product based on p's ID
			order.getProducts().add(product); //Add this new product on the order list, so now the product is associated to the order
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
