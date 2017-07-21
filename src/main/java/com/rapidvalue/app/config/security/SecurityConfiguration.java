package com.rapidvalue.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.rapidvalue.app.security.CustomBasicAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	private static String REALM="MY_TEST_REALM";
	
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("bill").password("password").roles("ADMIN");
		builder.inMemoryAuthentication().withUser("joe").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and().httpBasic().authenticationEntryPoint(getBasicAuthEntryPoint());
		
		/*http.csrf().disable()
		.httpBasic().authenticationEntryPoint(getBasicAuthEntryPoint())
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
		/*.and()
		.authorizeRequests()
		.antMatchers("/api/**").hasRole("ADMIN")*/;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
	@Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

}
