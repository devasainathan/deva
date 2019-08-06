package com.deva.project;

import javax.activation.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sun.xml.fastinfoset.sax.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.deva")

public class DBConfig 
{
	@Bean(name="ds")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/S190126");
		ds.setUsername("sid");
		ds.setPassword("sid");
		System.out.println("data source object is created");
		DataSource DataSource = null;	
		return DataSource;
	}
	@Bean(name="sf")
	public SessionFactory getSessionFactory()
	
	{
		Properties hp=new Properties();
		hp.put("hibernate.hbm2ddl.auto","update");
		hp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder fact=new LocalSessionFactoryBuilder((javax.sql.DataSource) this.getH2DataSource());
		fact.addProperties(hp);
		
		SessionFactory sf=fact.buildSessionFactory();
		System.out.println("SessionFactory Object is created");
		SessionFactory SessionFactory;
		return SessionFactory;
		
	}
	
	@Bean(name="tm")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf)
	{
System.out.println("hibernate transaction manager object is created");
return new HibernateTransactionManager(sf);
	}		
}
