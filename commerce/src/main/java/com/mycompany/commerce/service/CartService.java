package com.mycompany.commerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.commerce.domain.Cart;


public interface CartService {
	
	public Optional<Cart> getCart(int id);
	
	public void updateCart(Cart cart);
	
}
