package com.buddies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.buddies")
public class ApplicationDispatcher
{
	 @Bean
	 public ViewResolver viewResolver()
	 {
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	     viewResolver.setViewClass(JstlView.class);
	     viewResolver.setPrefix("/WEB-INF/views/");
	     viewResolver.setSuffix(".jsp");
	     return viewResolver;
	 }
	 
	 @Bean(name="multipartResolver") 
	 public MultipartResolver getMultiResolver()
	 {
		 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		 return multipartResolver;
	 }
}