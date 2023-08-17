package com.nnr.gestionDeTachesCollaboratif.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.security.AccountService;

import lombok.AllArgsConstructor;
import lombok.Data;


@RestController
@CrossOrigin("*")
public class UsersController {
	/**
	 * @author Roumuald
	 */
	
	private AccountService accountService;

	public UsersController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<String> registerUser(@RequestBody ConnectUser user) {
        accountService.addNewUser(user.getUser(), user.getConfirmPassword());
        return ResponseEntity.ok("User registered successfully");
    }
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewRole")
	public AppRoles addNewRole(@RequestBody AppRoles role) {
		return accountService.addNewRole(role);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/addRoleToUser")
	public void addRoleToUser(@RequestBody RolesUserForm roleUserForm) {
		accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/moveRoleToUser")
	public void moveRoleToUser(@RequestBody RolesUserForm roleUserForm) {
		accountService.moveRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<Users> getUser(){
		return accountService.getAllUsers();
	}

}

@Data
@AllArgsConstructor
class RolesUserForm{
	private String username;
	private String roleName;
}

@Data
@AllArgsConstructor
class ConnectUser {
	private Users user;
	private String confirmPassword;

}
