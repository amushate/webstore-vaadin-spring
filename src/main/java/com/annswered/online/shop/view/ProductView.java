/**
 * 
 */
package com.annswered.online.shop.view;

import java.math.BigDecimal;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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

	private static final long serialVersionUID = 1L;
	Label heading=new Label("<b>Products<b>",ContentMode.HTML);
	public ProductView() {
		//addStyleName("example-gridlayout");
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(heading);
		GridLayout grid=new GridLayout(3,4);
		grid.setSpacing(true);
		Panel panel=new Panel("Food");
		ItemView itemView=new ItemView("Food", BigDecimal.TEN, "ans");
		//itemView.setMargin(true);
		//panel.setCaption(itemView.getCaption());
		panel.setContent(itemView);
		grid.addComponent(panel);
		
		panel=new Panel("Book");
		itemView=new ItemView("Book", BigDecimal.TEN, "dammy");
		panel.setContent(itemView);
		grid.addComponent(panel);
		
		panel=new Panel("Item");
		itemView=new ItemView("Item", BigDecimal.TEN, "unnamed");
		panel.setContent(itemView);
		grid.addComponent(panel);
		
		panel=new Panel("Animal");
		itemView=new ItemView("Animal", BigDecimal.TEN, "ans");
		panel.setContent(itemView);
		grid.addComponent(panel);
		
		panel=new Panel("Gold");
		itemView=new ItemView("Gold", BigDecimal.TEN, "ans");
		panel.setContent(itemView);
		grid.addComponent(panel);
		
		addComponent(grid);
	}

}
