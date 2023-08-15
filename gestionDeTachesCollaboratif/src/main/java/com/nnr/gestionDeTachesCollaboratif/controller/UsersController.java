package com.nnr.gestionDeTachesCollaboratif.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.service.InterfaceUsers;

@RestController
@CrossOrigin("*")
public class UsersController {
	/**
	 * @author Roumuald
	 */
	
    private InterfaceUsers interfaceUsers;

    public UsersController(InterfaceUsers interfaceUsers) {
		super();
		this.interfaceUsers = interfaceUsers;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        interfaceUsers.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<Users> getUser(){
		return interfaceUsers.getUser();
	}

}
