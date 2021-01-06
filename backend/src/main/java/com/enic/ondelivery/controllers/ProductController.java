package com.enic.ondelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enic.ondelivery.dto.ProductDTO;
import com.enic.ondelivery.services.ProductService;

@RestController //Now the class is a rest controller
@RequestMapping(value = "/products") //Defines resource path
public class ProductController {

	@Autowired //SpringBoot resource to create a dependency injection automatically
	private ProductService service;
	
	@GetMapping //Create an ending point
	public ResponseEntity<List<ProductDTO>> find(){ //Special type that encapsulates a response HTTP
		List<ProductDTO> list = service.find();
		return ResponseEntity.ok().body(list); //ok says when the requisition was successfully made [ok code HTTP is 200]
	}
}