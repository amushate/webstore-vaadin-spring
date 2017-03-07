package com.annswered.online.shop.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 */
@Configuration
@EnableJpaRepositories("com.annswered.online")
@EnableTransactionManagement
@ComponentScan("com.annswered.online")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
public class DataConfiguration {

	@Autowired
	Environment evn;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		String username=evn.getProperty("jdbc.username");
		String password=evn.getProperty("jdbc.password");
		String url=evn.getProperty("jdbc.url");
		String driverClassName=evn.getProperty("jdbc.driverClassName");
		
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		
		return dataSource;
		/**EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();*/
		
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		//EclipseLinkJpaVendorAdapter vendorAdapter=new EclipseLinkJpaVendorAdapter();
		HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		Properties jpaProperties=new Properties();
		jpaProperties.put("showSql", evn.getProperty("showSql"));
		//jpaProperties.put("databasePlatform", "org.eclipse.persistence.platform.database.MySQLPlatform");
		jpaProperties.put("hibernate.hbm2ddl.auto", evn.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.dialect", evn.getProperty("hibernate.dialect"));//""");
		//jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(evn.getProperty("packages.to.scan"));
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();	
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager txManager=new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	
}
