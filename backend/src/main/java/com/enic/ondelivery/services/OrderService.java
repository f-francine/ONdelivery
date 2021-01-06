package com.enic.ondelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enic.ondelivery.dto.OrderDTO;
import com.enic.ondelivery.entities.Order;
import com.enic.ondelivery.repositories.OrderRepository;

@Service //Makes the class a registered component that can be injected in other components
public class OrderService {
	
	@Autowired //SpringBoot resource to make a dependency injection automatically
	private OrderRepository repository;
	
	@Transactional(readOnly=true)
	public List<OrderDTO> find(){
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); //Lambda expression
	}
}
