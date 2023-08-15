package com.nnr.gestionDeTachesCollaboratif.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nnr.gestionDeTachesCollaboratif.service.UserService;

@Configuration
public class GestionDeTachesCollaboratifSecurityConfig {    
	    @Autowired
	    private UserService userService;

	    @Bean
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	    }
	    
	    public InMemoryUserDetailsManager user(AuthenticationManagerBuilder auth) {
	    	return new InMemoryUserDetailsManager();
	    }
	    
	    @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().requestMatchers("/signup").permitAll()/*.anyRequest().authenticated()*/
            .and()
			.formLogin()/*.loginPage("/login").defaultSuccessUrl("/dashbord",true).permitAll()*/
			.and()
			.logout().permitAll();
//			http.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();
//			http.authorizeHttpRequests().requestMatchers("/css/gestionCinema.css").permitAll();
//			http.authorizeHttpRequests().anyRequest().authenticated();
			return http.build();	
		}
	   
		
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
