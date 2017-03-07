/**
 * 
 */
package com.annswered.online.shop.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.annswered.online.shop.model.Cart;
import com.annswered.online.shop.model.CartItem;
import com.annswered.online.shop.model.StockItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * @author amushate
 *
 */
public class CartView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	Label heading=new Label("<b>Cart<b>",ContentMode.HTML);
	Cart cart=(Cart) VaadinSession.getCurrent().getAttribute("cart");
	List<CartItem> items=cart!=null?cart.getItems():new ArrayList<>();
	Label totalLabel=new Label();
	@Override
	public void enter(ViewChangeEvent event) {
		/*items=new ArrayList<>();
		CartItem testitem=new CartItem();
		testitem.setCart(cart);
		testitem.setCartitemId(1);
		testitem.setQty(BigDecimal.valueOf(3.00));
		StockItem stockItem=new StockItem();
		testitem.setStockItem(new StockItem());*/
		addComponent(heading);
		for (CartItem item : dammycart().getItems()) {
			CartItemView cartItem=new CartItemView(item);	
			Panel panel=new Panel();
			panel.setContent(cartItem);
			addComponent(panel);
		}
		BigDecimal total=BigDecimal.valueOf(0.00);
		total=cart!=null?cart.getTotalPrice():BigDecimal.valueOf(0.00);
		totalLabel.setCaption("Total:$"+total.toString());
		Label space=new Label();
		addComponent(space);
		addComponent(totalLabel);
		this.setComponentAlignment(totalLabel, Alignment.BOTTOM_RIGHT);
	}
	
	private Cart dammycart(){
		items=new ArrayList<>();
		cart=new Cart();
		cart.setCartId(1);
		CartItem testitem=new CartItem();
		testitem.setCart(cart);
		testitem.setCartitemId(1);
		testitem.setQty(BigDecimal.valueOf(3.00));
		
		StockItem stockItem=new StockItem();
		stockItem.setDescription("My first Item");
		stockItem.setPrice(BigDecimal.valueOf(3.00));
		stockItem.setImage("1.jpg");
		
		testitem.setStockItem(stockItem);
		
		CartItem testitem2=new CartItem();
		testitem2.setCart(cart);
		testitem2.setCartitemId(1);
		testitem2.setQty(BigDecimal.valueOf(3.00));
		
		StockItem stockItem2=new StockItem();
		stockItem2.setDescription("My first Item");
		stockItem2.setPrice(BigDecimal.valueOf(3.00));
		stockItem2.setImage("2.jpg");
		
		testitem2.setStockItem(stockItem2);
		
		items.add(testitem);
		items.add(testitem2);
		cart.setItems(items);
		return cart;		
	}

}
