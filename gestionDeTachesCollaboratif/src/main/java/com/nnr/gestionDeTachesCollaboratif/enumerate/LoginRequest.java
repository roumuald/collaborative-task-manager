package com.nnr.gestionDeTachesCollaboratif.enumerate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
	
	private String email;
	
	private String password;

}