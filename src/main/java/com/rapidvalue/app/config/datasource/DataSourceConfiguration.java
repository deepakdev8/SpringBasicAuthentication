package com.rapidvalue.app.config.datasource;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		try {
			basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			basicDataSource.setUsername("root");
			basicDataSource.setPassword("nopassword");
	        basicDataSource.setUrl("jdbc:mysql://localhost:3306/sample");

	    } catch (Exception e) {
	       e.printStackTrace();
	    }
		
		return basicDataSource;
	}

}
