/**
 * 
 */
package com.annswered.online.shop.view;

import java.math.BigDecimal;

import com.annswered.online.shop.model.Cart;
import com.annswered.online.shop.model.CartItem;
import com.annswered.online.shop.model.StockItem;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author amushate
 *
 */
public class ItemView extends VerticalLayout {
	
	VaadinSession session=VaadinSession.getCurrent();
	Cart cart=(Cart) session.getAttribute("cart");
	private static final long serialVersionUID = 1L;
	Label priceLabel;
	HorizontalLayout qtyAndTotal=new HorizontalLayout();
	HorizontalLayout imageAndPrice=new HorizontalLayout();
	
	Embedded itemImage;
	public ItemView(CartItem cartItem){
		StockItem stockItem = cartItem.getStockItem();
		priceLabel=new Label("Price<br>$"+stockItem.getPrice(),ContentMode.HTML);
		itemImage= new Embedded( null, new ThemeResource( "img/"+stockItem.getImage()) );
		itemImage.setWidth("180px"); 
		itemImage.setHeight("140px");
		
		Button subtract=new Button("-");
		Label qtyLabel=new Label("Qty<br>"+cartItem.getQty(),ContentMode.HTML);
		qtyLabel.setCaptionAsHtml(true);
		Label totalLabel=new Label("Total<br>$"+cartItem.getTotal(),ContentMode.HTML);
		totalLabel.setCaptionAsHtml(true);
		Button add=new Button("+");
		
		subtract.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				if(cartItem.getQty().compareTo(BigDecimal.ZERO)==0){
					if(itemInCart(cartItem)){
						cart.getItems().remove(cartItem);
					}
					return;
				}
				cartItem.setQty(cartItem.getQty().subtract(BigDecimal.ONE));//=qty.multiply(price);
				qtyLabel.setValue("Qty<br>"+cartItem.getQty());				
				totalLabel.setValue("Total<br>$"+cartItem.getTotal());
				if(cartItem.getQty().compareTo(BigDecimal.ZERO)==0){
					if(itemInCart(cartItem)){
						cart.getItems().remove(cartItem);
					}
				}
			}
		});
		
		add.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {				
				cartItem.setQty(cartItem.getQty().add(BigDecimal.ONE));//=qty.multiply(price);
				qtyLabel.setValue("Qty<br>"+cartItem.getQty());				
				totalLabel.setValue("Total<br>$"+cartItem.getTotal());
				if(!itemInCart(cartItem)){
					cart.getItems().add(cartItem);
				}
			}
		});
		Label space=new Label();
		
		imageAndPrice.addComponent(itemImage);
		imageAndPrice.addComponent(priceLabel);
		imageAndPrice.setComponentAlignment(priceLabel, Alignment.MIDDLE_RIGHT);

		qtyAndTotal.addComponent(add);
		qtyAndTotal.addComponent(subtract);
		qtyAndTotal.addComponent(qtyLabel);
		qtyAndTotal.addComponent(space);
		qtyAndTotal.addComponent(totalLabel);
		
		addComponent(imageAndPrice);
		addComponent(qtyAndTotal);
	}
	
	private boolean itemInCart(CartItem cartItem){
		boolean exist=false;		
		for(CartItem incart:cart.getItems()){
			if(incart.getStockItem().getStockitemId()==cartItem.getStockItem().getStockitemId()){
				exist=true;
				break;
			}
		}
		return exist;			
	}
	
}
