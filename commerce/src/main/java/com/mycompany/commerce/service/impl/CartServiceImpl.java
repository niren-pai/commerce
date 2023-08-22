package com.mycompany.commerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycompany.commerce.domain.Cart;
import com.mycompany.commerce.repository.CartRepository;
import com.mycompany.commerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	
	CartRepository cartRepository;
	
	@Autowired
	CartServiceImpl(CartRepository repository){
	this.cartRepository = repository;
	}

	public Optional<Cart> getCart(int id) { 
		return this.cartRepository.findById(id); 
		}
	
	public void updateCart(Cart cart) {
		this.cartRepository.save(cart);	
	}
	
}
