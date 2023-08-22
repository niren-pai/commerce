/**
 * 
 */
package com.mycompany.commerce.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Niren
 *
 */

import com.mycompany.commerce.domain.Cart;



public interface CartRepository extends CrudRepository<Cart, Integer>{
	
	
	

}
