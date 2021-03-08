package com.mms.ssjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mms.ssjpa.service.MUserDetailsService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired MUserDetailsService uds;
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(uds);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

    
		http.authorizeRequests()
		    .antMatchers(HttpMethod.POST).permitAll()
		    .antMatchers("/home").hasAnyAuthority("USER","ADMIN")
		    .antMatchers(HttpMethod.PUT).hasAuthority("ADMIN")
		    .antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
		    .and().httpBasic();
		  http.csrf().disable();
		    
	}
	
}
