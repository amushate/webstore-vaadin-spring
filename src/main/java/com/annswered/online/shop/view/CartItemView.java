/**
 * 
 */
package com.annswered.online.shop.view;

import com.annswered.online.shop.model.CartItem;
import com.annswered.online.shop.model.StockItem;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author amushate
 *
 */
public class CartItemView extends HorizontalLayout {

	private static final long serialVersionUID = 1L;
	
	Embedded itemImage;
	private StockItem item;
	Label priceLabel;
	Label totalPriceLabel;
	Label qtyLabel;
	public CartItemView(CartItem cartItem){
		item=cartItem.getStockItem();
		itemImage= new Embedded(null, new ThemeResource( "img/"+item.getImage()));
		itemImage.setWidth("100px"); 
		itemImage.setHeight("80px");
		//itemLabel=new Label(item.getDescription());
		priceLabel=new Label(item.getPrice().toString());
		qtyLabel=new Label(cartItem.getQty().toString());
		totalPriceLabel=new Label(cartItem.getTotal().toString());
		//addComponent(itemLabel);
		addComponent(itemImage);
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(priceLabel);
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(qtyLabel);
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(new Label());
		addComponent(totalPriceLabel);
		
		//set alignment
		//setComponentAlignment(priceLabel, Alignment.MIDDLE_RIGHT);
		setComponentAlignment(priceLabel, Alignment.MIDDLE_RIGHT);
		setComponentAlignment(qtyLabel, Alignment.MIDDLE_RIGHT);
		setComponentAlignment(totalPriceLabel, Alignment.MIDDLE_RIGHT);
	}
	
}
