/**
 * 
 */
package com.annswered.online.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author amushate
 *
 */
@Entity
@Table(name="cart")
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	@OneToOne//(optional=false, mappedBy="cart")
	User user;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cart")
	List<CartItem>items=new ArrayList<>();
	
	@Column(name="total_price")
	BigDecimal totalPrice=BigDecimal.ZERO;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
		if(items!=null && !items.isEmpty()){
			for (CartItem cartItem : items) {
				if(cartItem.getTotal()!=null){
					totalPrice.add(cartItem.getTotal());
				}				
			}
		}
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	
	
}
