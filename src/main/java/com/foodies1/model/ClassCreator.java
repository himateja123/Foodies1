package com.foodies1.model;

import java.util.HashMap;
import java.util.Map;

public class ClassCreator {
	
	Map<Integer,CartItem> cart;
	
	public ClassCreator() {
		cart = new HashMap<Integer,CartItem>();
		
	}
	
	public void addCartItem(CartItem item) {
		
		if(cart.containsKey(item.getMenu_id())) {
			
			int n1 = cart.get(item.getMenu_id()).getQuantity();
			int n2 = item.getQuantity();
			int n3= n1+n2;
			
			item.setQuantity(n3);
			cart.put(item.getMenu_id(), item);
		}
		else {
			cart.put(item.getMenu_id(),item);
		}
	}
	
	public void updateCartItem(int menu_id, int quantity) {

	    if(cart.containsKey(menu_id)) {
	        cart.get(menu_id).setQuantity(quantity);
	    }
	}
	 
	
	public Map<Integer, CartItem> getItems() {
        return cart;
    }
	
	public void deleteCartItem(int menu_id) {
		if(cart.containsKey(menu_id)) {
			cart.remove(menu_id);
		}
	}
	
	
}
