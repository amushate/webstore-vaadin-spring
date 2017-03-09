/**
 * 
 */
package com.annswered.online.shop.model.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annswered.online.shop.config.test.DataConfigurationTest;
import com.annswered.online.shop.model.ItemMeasure;
import com.annswered.online.shop.model.ItemStatus;
import com.annswered.online.shop.model.StockItem;
import com.annswered.online.shop.model.User;
import com.annswered.online.shop.repositories.StockItemRepository;
import com.annswered.online.shop.repositories.UserRepository;

/**
 * @author amushate
 *
 */
public class StockItemTest {
	
	ApplicationContext cxt=null;
	
	@Before
	public void init(){
		cxt=new AnnotationConfigApplicationContext(DataConfigurationTest.class);		
	}
	
	@Test
	public void SaveStockItemTest(){
		User user=new User();
		user.setName("Anesu");
		user.setPassword("ratarata");
		user.setSurname("Mushate");
		user.setCreatedDate(new Date());
		user.setUsername("amushate");
		UserRepository userRepo=cxt.getBean(UserRepository.class);
		userRepo.save(user);
		StockItem item=new StockItem();
		item.setCreatedBy(user);
		item.setImage("1.png");
		item.setCreatedDate(new Date());
		item.setMeasure(ItemMeasure.UNIT);
		item.setStatus(ItemStatus.ACTIVE);
		item.setDescription("O'level English");
		StockItemRepository repo=cxt.getBean(StockItemRepository.class);
		repo.save(item);		
	}
	
}
