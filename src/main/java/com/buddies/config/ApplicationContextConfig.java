package com.buddies.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.buddies.model.Blog;
import com.buddies.model.Chat;
import com.buddies.model.Comment;
import com.buddies.model.Event;
import com.buddies.model.Forum;
import com.buddies.model.Friend;
import com.buddies.model.User;
import com.buddies.model.UserFriend;
import com.buddies.model.UserRole;


@Configuration  /*This can be used by spring container as a source of bean*/
@ComponentScan("com.buddies")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
/*	@Bean is used to return an object that is registered as bean in springs*/
	@Bean(name = "dataSource")
	public DataSource getdataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/buddies");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
    
    private Properties getHibernateProperties()
    {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Blog.class);
    	sessionBuilder.addAnnotatedClasses(Chat.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(UserRole.class);
    	sessionBuilder.addAnnotatedClasses(Event.class);
    	sessionBuilder.addAnnotatedClasses(Comment.class);
    	sessionBuilder.addAnnotatedClasses(Forum.class);
    	sessionBuilder.addAnnotatedClasses(UserFriend.class);
    	sessionBuilder.addAnnotatedClasses(Friend.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}