package com.nnr.gestionDeTachesCollaboratif.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService{
	
	private AccountService accountService;

	public UserService(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = accountService.loaderUserByEmailUser(email);
		if(user==null) throw new GestionDeTachesCollaboratifException("pas d'utilisateur avec l'email"+ email);
		String[] role = user.getRoles().stream().map(u->u.getRoleName()).toArray(String[]::new);//converti une liste d'objet en tableau de string
		UserDetails userDetail = User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(role).build();
		return userDetail;
	}
}
