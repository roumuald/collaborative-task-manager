package com.nnr.gestionDeTachesCollaboratif.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.gestionDeTachesCollaboratif.model.MemberProjet;
import com.nnr.gestionDeTachesCollaboratif.model.Projet;
import com.nnr.gestionDeTachesCollaboratif.service.InterfaceProjet;

@RestController
@CrossOrigin("*")
public class ProjetController {
	/**
	 * @author Roumuald
	 */
	
	private InterfaceProjet interfaceProjet;

	public ProjetController(InterfaceProjet interfaceProjet) {
		super();
		this.interfaceProjet = interfaceProjet;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/newProjet/{idUser}")
	public Projet newProjet(@RequestBody Projet projet, @PathVariable Long idUser) {
		return interfaceProjet.newProjet(projet, idUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateProjet/{idProjet}/{idUser}")
	public Projet updateProjet(@RequestBody Projet newProjet, @PathVariable Long idProjet, @PathVariable Long idUser) {
		return interfaceProjet.updateProjet(newProjet, idProjet, idUser);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteProjet/{idProjet}")
	public ResponseEntity<String> deleteProjet(@PathVariable Long idProjet) {
		interfaceProjet.deleteProjet(idProjet);
		return ResponseEntity.ok("Utilisateur supprime avec success !!!");
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/addUserToProjet/{idProjet}/{idUser}")
	public ResponseEntity<String> addUserToProjet(@RequestBody MemberProjet member, @PathVariable Long idProjet, @PathVariable Long idUser) {
		interfaceProjet.addUserToProjet(member, idProjet, idUser);
		return ResponseEntity.ok("Membre ajoute au projet avec success !!!");
		
	}

}
