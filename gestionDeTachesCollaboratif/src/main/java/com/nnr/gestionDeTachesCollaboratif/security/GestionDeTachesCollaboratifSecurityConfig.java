package com.nnr.gestionDeTachesCollaboratif.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class GestionDeTachesCollaboratifSecurityConfig {   
	
	    @Autowired
	    private UserService userService;
	    
	    @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.authorizeRequests().requestMatchers(HttpMethod.POST).permitAll();/*.anyRequest().authenticated()*/
			http.formLogin().defaultSuccessUrl("/users", true);/*.loginPage("/login").defaultSuccessUrl("/dashbord",true).permitAll()*/
			http.logout().permitAll();
			http.userDetailsService(userService);
			return http.build();	
		}
}
