package com.rapidvalue.app.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rapidvalue.app.config.datasource.DataSourceConfiguration;
import com.rapidvalue.app.config.hibernate.HibernateConfiguration;
import com.rapidvalue.app.config.repository.RepositoryConfiguration;
import com.rapidvalue.app.config.security.SecurityConfiguration;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.rapidvalue.app" })
@Import({ 
	DataSourceConfiguration.class,
	RepositoryConfiguration.class,
	HibernateConfiguration.class,
	SecurityConfiguration.class 
	})
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;	
	
	@PostConstruct
	public void init(){
		requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}

}
