package com.nnr.gestionDeTachesCollaboratif.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments implements Serializable{

	/**
	 * @author Roumuald
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String content;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date createdDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Tasks task;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Users user;

}
