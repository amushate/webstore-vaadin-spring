/**
 * 
 */
package com.annswered.online.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author amushate
 *
 */
@Entity
@Table(name="cart_item")
public class CartItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cartitem_id")
	private int cartitemId;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	@Column(name="stock_item")
	private StockItem stockItem;
	
	@Column(name="qty")
	private BigDecimal qty=BigDecimal.valueOf(0, 2);
	
	@Column(name="total")
	private BigDecimal total=BigDecimal.valueOf(0, 2);;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public StockItem getStockItem() {
		return stockItem;
	}

	public void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
		if(qty!=null && stockItem!=null && stockItem.getPrice()!=null){
			total=qty.multiply(stockItem.getPrice());
		}
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
		if(qty!=null && stockItem!=null && stockItem.getPrice()!=null){
			total=qty.multiply(stockItem.getPrice());
		}
	}

	public BigDecimal getTotal() {
		return total;
	}

	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}
	
	
}
