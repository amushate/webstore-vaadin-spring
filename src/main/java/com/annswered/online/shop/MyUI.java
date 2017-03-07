package com.annswered.online.shop;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annswered.online.shop.config.DataConfiguration;
import com.annswered.online.shop.view.CartView;
import com.annswered.online.shop.view.HomeView;
import com.annswered.online.shop.view.LoginView;
import com.annswered.online.shop.view.ProductView;
import com.annswered.online.shop.view.SearchView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * @author amushate
 */
@Theme("mytheme")
public class MyUI extends UI {

    private static final long serialVersionUID = 1L;

    static ApplicationContext context;
    
	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	final VerticalLayout layout = new VerticalLayout();
    	Panel panel=new Panel();
    	
        final HorizontalLayout topBar=new HorizontalLayout();
        HorizontalLayout topBarContainer = new HorizontalLayout();
        HorizontalLayout footerContainer = new HorizontalLayout();
        footerContainer.addComponent(initFooter());
        
        final HorizontalLayout viewLayout=new HorizontalLayout();
        
        layout.addComponent(topBarContainer);
        layout.setComponentAlignment(topBarContainer, Alignment.TOP_CENTER);
        layout.addComponent(viewLayout);
        layout.setComponentAlignment(viewLayout, Alignment.MIDDLE_CENTER);
        
        layout.addComponent(footerContainer);
        layout.setComponentAlignment(footerContainer, Alignment.BOTTOM_CENTER);
        layout.addComponent(new Label());
        
        setContent(layout);     
        
        final Navigator navigator=new Navigator(this,viewLayout);
        navigator.addView("Home", HomeView.class);
        navigator.addView("Products", ProductView.class);
        navigator.addView("Cart", CartView.class);
        navigator.addView("Login", LoginView.class);
        navigator.addView("Search", SearchView.class);
        navigator.addView("", HomeView.class);
        
        Embedded logo=getlogo();
        topBar.addComponent(logo);
        topBar.addComponent(new Label());
        topBar.addComponent(new Label());
        topBar.setComponentAlignment(logo, Alignment.BOTTOM_LEFT);
        for (String c : new String[]{"Home","Products","Login","Search"}) {
        	Button button=this.createNavigationButton(c,navigator);
			topBar.addComponent(button);
			topBar.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		}
        Button cart=this.createNavigationButton("Cart",navigator);
        topBar.addComponent(cart);
		topBar.setComponentAlignment(cart, Alignment.MIDDLE_RIGHT);
		topBar.addComponent(new Label());
		topBar.addComponent(new Label());
		panel.setContent(topBar);
		panel.setSizeFull();
		panel.setStyleName("my-panel-header");
		topBarContainer.addComponent(panel);
    }

	/**
	 * Create a Horizontal footer that will be applied to all the pages
	 * 
	 * @return
	 */
    private Panel initFooter() {
    	
       	final HorizontalLayout footer=new HorizontalLayout();
    	for(String heading:new String[]{"Copyright@Annswered.com","Contact Us","About us","FaceBook","Twiter"}){
    		Button btn=new Button(heading);
    		btn.setStyleName(BaseTheme.BUTTON_LINK);
        	footer.addComponent(btn);
    	}
    	Panel panel=new Panel();
    	panel.setStyleName("my-panel-header");
    	panel.setContent(footer);
    	//final HorizontalLayout footerContainer=new HorizontalLayout();
    	//footerContainer.addComponent(footer);
		return panel;
	}

	private Embedded getlogo(){
    	// A theme resource in the current theme ("mytheme")
    	// Located in: VAADIN/themes/mytheme/img/themeimage.png
    	//ThemeResource resource = new ThemeResource("img/ans.png");

    	// Use the resource
    	//Image image = new Image("", resource);
    	Embedded reindeerImage = new Embedded( null, new ThemeResource( "img/ans.png" ) );
    	reindeerImage.setWidth( "200px" ); 
    	reindeerImage.setHeight( "180px" );
    	
    	return reindeerImage;
		//return image;
    	
    }
    
    private Button createNavigationButton(String state,Navigator navigator){
    	
    	Button button=new Button(state);
    	button.setStyleName(BaseTheme.BUTTON_LINK);
    	button.setWidth(5f, Unit.PERCENTAGE);
    	button.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo(state);				
			}
		});
    	return button;
    	
    }
    
    /*private ApplicationContext initDba(){
    	ApplicationContext context=null;
    	try(AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(DataConfiguration.class)){
    		//this.context=cxt;
			//BookService service=context.getBean(BookService.class);
			//Book book=new Book("First book", new Date(), 33, new BigDecimal("26.00"));
			//service.save(book);
			//System.out.println(book);
		}
    	return context;
    }*/
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
		//context=initDba();
		//private ApplicationContext initDba(){
	    	{
	    		//ApplicationContext context=null;
	    	
	    	try(AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(DataConfiguration.class)){
	    		context=cxt;
				//BookService service=context.getBean(BookService.class);
				//Book book=new Book("First book", new Date(), 33, new BigDecimal("26.00"));
				//service.save(book);
				//System.out.println(book);
			}
	    	//return context;
	    	}
	   // }
    }
}
