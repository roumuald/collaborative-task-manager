package com.nnr.gestionDeTachesCollaboratif;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.security.AccountService;

@SpringBootApplication
public class GestionDeTachesCollaboratifApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeTachesCollaboratifApplication.class, args);
	}
	
	//@Bean
	CommandLineRunner command(AccountService accountService) {
		return arg->{
			accountService.addNewUser(new Users(null, "Roumuald", "nnr@gmail.com", "nnr", null, null, null, null, null), "nnr");
			accountService.addNewUser(new Users(null, "prielle", "prielle@gmail.com", "nnr", null, null, null, null, null), "nnr");
			accountService.addNewUser(new Users(null, "liams", "liams@gmail.com", "nnr", null, null, null, null, null), "nnr");
			
			accountService.addNewRole(new AppRoles(null, "ADMIN"));
			accountService.addNewRole(new AppRoles(null, "MEMBER"));
			accountService.addNewRole(new AppRoles(null, "CHEF PROJET"));
			
			accountService.addRoleToUser("nnr@gmail.com", "ADMIN");
			accountService.addRoleToUser("prielle@gmail.com", "MEMBER");
			accountService.addRoleToUser("liams@gmail.com", "CHEF PROJET");
		};
	}

}
