package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.List;

import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;

public interface InterfaceUsers {
	
	public void registerUser(Users user);
	
	public List<Users> getUser();

	public void addRolesToUser(String email, String roleName);
	
	public AppRoles newRoles(AppRoles roles);
}
