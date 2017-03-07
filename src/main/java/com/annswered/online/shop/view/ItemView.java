/**
 * 
 */
package com.annswered.online.shop.view;

import java.math.BigDecimal;

import com.vaadin.server.ThemeResource;
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
	
	private static final long serialVersionUID = 1L;
	Label nameLabel;
	Label priceLabel;
	HorizontalLayout qtyAndTotal=new HorizontalLayout();
	HorizontalLayout imageAndPrice=new HorizontalLayout();
	
	Embedded itemImage;
	BigDecimal price,qty=BigDecimal.valueOf(0,2),total=BigDecimal.valueOf(0,2);
	public ItemView(String name,BigDecimal price,String image){
		
		nameLabel=new Label(name);
		priceLabel=new Label("Price<br>$"+price,ContentMode.HTML);
		itemImage= new Embedded( null, new ThemeResource( "img/"+image+".png" ) );
		itemImage.setWidth("180px"); 
		itemImage.setHeight("140px");
		
		Button subtract=new Button("-");
		Label qtyLabel=new Label("Qty<br>"+qty,ContentMode.HTML);
		qtyLabel.setCaptionAsHtml(true);
		Label totalLabel=new Label("Total<br>$"+total,ContentMode.HTML);
		totalLabel.setCaptionAsHtml(true);
		Button add=new Button("+");
		
		subtract.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				if(qty.compareTo(BigDecimal.ZERO)==0){
					return;
				}
				qty=qty.subtract(BigDecimal.ONE);
				qtyLabel.setValue("Qty<br>"+qty);
				total=qty.multiply(price);
				totalLabel.setValue("Total<br>$"+total);
			}
		});
		
		add.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				qty=qty.add(BigDecimal.ONE);
				qtyLabel.setValue("Qty<br>"+qty);
				total=qty.multiply(price);				
				totalLabel.setValue("Total<br>$"+total);				
			}
		});
		Label space=new Label();
		
		imageAndPrice.addComponent(itemImage);
		imageAndPrice.addComponent(priceLabel);
		imageAndPrice.setComponentAlignment(priceLabel, Alignment.MIDDLE_RIGHT);
		//layout.addComponent(priceLabel);
		qtyAndTotal.addComponent(add);
		qtyAndTotal.addComponent(subtract);
		qtyAndTotal.addComponent(qtyLabel);
		qtyAndTotal.addComponent(space);
		qtyAndTotal.addComponent(totalLabel);
		addComponent(imageAndPrice);
		addComponent(qtyAndTotal);
	}
	
}
