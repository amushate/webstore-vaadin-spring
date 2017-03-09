/**
 * 
 */
package com.annswered.online.shop.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.annswered.online.shop.model.Cart;
import com.annswered.online.shop.model.CartItem;
import com.annswered.online.shop.model.StockItem;
import com.annswered.online.shop.repositories.StockItemRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * @author amushate
 *
 */
public class ProductView extends VerticalLayout implements View {

	
	VaadinSession session=VaadinSession.getCurrent();
	ApplicationContext cxt=(ApplicationContext) session.getAttribute("context");
	Cart cart;
	private static final long serialVersionUID = 1L;
	Label heading=new Label("<b>Products<b>",ContentMode.HTML);
	public ProductView() {
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		
		cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart", cart);
			
		}
		initView();
	}
	
	
	private void initView(){
		addComponent(heading);
		GridLayout grid=new GridLayout(3,4);
		grid.setSpacing(true);
		
		for(CartItem item:getItems()){
			Panel panel=new Panel(item.getStockItem().getDescription());
			ItemView itemView=new ItemView(item);
			panel.setContent(itemView);
			grid.addComponent(panel);
		}
	
		addComponent(grid);
	}
	
	private List<CartItem> getItems(){
		
		
		StockItemRepository stockItemRepository=cxt.getBean(StockItemRepository.class);
		//UserRepository userRepository=cxt.getBean(UserRepository.class);
		
		/*User user=new User();
		user.setCreatedDate(new Date());
		user.setCart(cart);
		cart.setUser(user);
		userRepository.save(user);
		
		StockItem stockItem=new StockItem();
		stockItem.setImage("ans");
		stockItem.setPrice(BigDecimal.TEN);
		stockItem.setDescription("Anesu");
		stockItem.setCreatedDate(new Date());
		stockItem.setStatus(ItemStatus.ACTIVE);
		stockItem.setMeasure(ItemMeasure.UNIT);
		stockItem.setCreatedBy(user);
		stockItemRepository.save(stockItem);*/
		Map<Integer,CartItem>itemInCart=new HashMap<>();
		if(cart!=null && cart.getItems()!=null && !cart.getItems().isEmpty()){
			for(CartItem cartItem:cart.getItems()){
				itemInCart.put(cartItem.getStockItem().getStockitemId(),cartItem);
			}
		}
		
		List<StockItem> items=stockItemRepository.findAll();
		List<CartItem> cartItems=new ArrayList<>();
		for(StockItem item:items){
			CartItem exist=itemInCart.get(item.getStockitemId());
			if(exist!=null){
				cartItems.add(exist);
			}else{
				exist=new CartItem();
				exist.setStockItem(item);
				cartItems.add(exist);
			}
			
		}
		return cartItems;
	}

}
