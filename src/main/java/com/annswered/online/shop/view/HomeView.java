/**
 * 
 */
package com.annswered.online.shop.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author amushate
 *
 */
public class HomeView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	Label heading=new Label("<b>Home<b>",ContentMode.HTML);
	
	@Override
	public void enter(ViewChangeEvent event) {
		VerticalLayout layout=new VerticalLayout();
		layout.addComponent(heading);
		
		Embedded reindeerImage = new Embedded( null, new ThemeResource( "img/ans.png" ) );
    	//reindeerImage.setWidth( "200px" ); 
    	//reindeerImage.setHeight( "180px" );
		
		layout.addComponent(reindeerImage);
		//layout.setComponentAlignment(heading, Alignment.MIDDLE_LEFT);
		addComponent(layout);
	}

}
