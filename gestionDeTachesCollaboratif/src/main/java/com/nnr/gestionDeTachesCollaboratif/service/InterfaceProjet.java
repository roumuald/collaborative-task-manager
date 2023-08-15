package com.nnr.gestionDeTachesCollaboratif.service;

import com.nnr.gestionDeTachesCollaboratif.model.MemberProjet;
import com.nnr.gestionDeTachesCollaboratif.model.Projet;

public interface InterfaceProjet {
	
	public Projet newProjet(Projet projet, Long idUser);
	
	public Projet updateProjet(Projet newProjet, Long idProjet, Long idUser);
	
	public void deleteProjet(Long idProjet);
	
	public void addUserToProjet(MemberProjet member, Long idProjet, Long idUser);

}
