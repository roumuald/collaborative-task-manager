package com.nnr.gestionDeTachesCollaboratif.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class AuthController {
	
	@RequestMapping(method = RequestMethod.GET, path ="/profil" )
	public Authentication auth(Authentication authentication) {
		return authentication;
	}
}
