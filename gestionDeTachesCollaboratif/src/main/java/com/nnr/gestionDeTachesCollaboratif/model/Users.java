package com.nnr.gestionDeTachesCollaboratif.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.nnr.gestionDeTachesCollaboratif.enumerate.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable{
	
	/**
	 * @author Roumuald
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	//@Enumerated(EnumType.STRING)
	//private Roles roles;
	
	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Projet> projet = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<MemberProjet> memberProjet = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<AttributionTasks> attributionTask = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Comments> comment = new ArrayList<>();
	
	@ManyToMany(fetch =FetchType.EAGER )
	private Collection<AppRoles> roles = new ArrayList<>();
	
	
	public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.password = hashedPassword;
    }

}
