package com.rapidvalue.app.config.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.rapidvalue.app.repository")
public class RepositoryConfiguration {

}
