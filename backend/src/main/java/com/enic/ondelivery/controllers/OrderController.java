package com.enic.ondelivery.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enic.ondelivery.dto.OrderDTO;
import com.enic.ondelivery.services.OrderService;

@RestController //Now the class is a rest controller
@RequestMapping(value = "/orders") //Defines resource path
public class OrderController {

	@Autowired //SpringBoot resource to create a dependency injection automatically
	private OrderService service;
	
	@GetMapping //Create an ending point
	public ResponseEntity<List<OrderDTO>> find(){ //Special type that encapsulates a response HTTP
		List<OrderDTO> list = service.find();
		return ResponseEntity.ok().body(list); //ok says when the requisition was successfully made [ok code HTTP is 200]
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto); //Returns a 201 code, witch is the right one when you make a insert
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){ //PathVariable used to match the id in the parameter to the {id} in the PUT mapping
		OrderDTO dto = service.setDelivered(id);
		return ResponseEntity.ok().body(dto); //Return code 200
	}
}