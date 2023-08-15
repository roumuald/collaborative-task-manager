package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

@Service
public class UserService implements UserDetailsService{
	
	private UsersRepository userRepository;
	
	public UserService(UsersRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(email);
		Collection<GrantedAuthority> authority = new ArrayList<>();
		user.getRoles().forEach(r->{
			authority.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(user.getEmail(), user.getPassword(), authority);
	}
}
