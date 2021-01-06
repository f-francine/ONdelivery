package com.enic.ondelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enic.ondelivery.dto.ProductDTO;
import com.enic.ondelivery.entities.Product;
import com.enic.ondelivery.repositories.ProductRepository;

@Service //Makes the class a registered component that can be injected in other components
public class ProductService {
	
	@Autowired //SpringBoot resource to make a dependency injection automatically
	private ProductRepository repository;
	
	@Transactional(readOnly=true)
	public List<ProductDTO> find(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList()); //Lambda expression
	}
}
