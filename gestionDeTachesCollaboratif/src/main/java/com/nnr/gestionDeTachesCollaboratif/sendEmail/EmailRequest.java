package com.nnr.gestionDeTachesCollaboratif.sendEmail;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
	
	private String expediteur;
    private String destinataire;
    private String sujet;
    private String contenu;

}
