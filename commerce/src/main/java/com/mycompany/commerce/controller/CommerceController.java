package com.mycompany.commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.commerce.domain.Cart;
import com.mycompany.commerce.service.CartService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class CommerceController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/ping")
	public String ping(){
		return "OK";
	}
	
	@GetMapping(value="/cart/{id}")
	public Optional<Cart> getCart(@PathVariable int id ) {
		return this.cartService.getCart(id);
	}
	
	@PostMapping("/cart")
	public void UpdateCart(@RequestBody Cart cart) {
		
		cartService.updateCart(cart);
	}
	

	
	
	
}
