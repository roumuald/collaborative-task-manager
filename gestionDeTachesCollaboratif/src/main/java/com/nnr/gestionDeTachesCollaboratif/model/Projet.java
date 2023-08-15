package com.nnr.gestionDeTachesCollaboratif.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nnr.gestionDeTachesCollaboratif.enumerate.ProjetStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projet implements Serializable{

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
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ProjetStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Users users;
	
	@OneToMany(mappedBy = "projet")
	@JsonIgnore
	private List<MemberProjet> memberProjet = new ArrayList<>();
	
	@OneToMany(mappedBy = "projet")
	@JsonIgnore
	private List<Tasks> tasks = new ArrayList<>();
	

}
