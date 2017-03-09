/**
 * 
 */
package com.annswered.online.shop.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.annswered.online.shop.model.Cart;
import com.annswered.online.shop.model.CartItem;
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
		addComponent(heading);
		BigDecimal total=BigDecimal.ZERO;
		for (CartItem item : items) {
			total=total.add(item.getTotal());
			CartItemView cartItem=new CartItemView(item);	
			Panel panel=new Panel();
			panel.setContent(cartItem);
			addComponent(panel);
		}
		
		totalLabel.setValue("Total:$"+total.toString());
		Label space=new Label();
		addComponent(space);
		addComponent(totalLabel);
		this.setComponentAlignment(totalLabel, Alignment.BOTTOM_RIGHT);
	}	
	
}
