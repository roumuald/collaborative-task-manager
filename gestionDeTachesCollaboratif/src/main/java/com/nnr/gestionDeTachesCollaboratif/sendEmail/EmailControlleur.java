package com.nnr.gestionDeTachesCollaboratif.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class EmailControlleur {
	
	/**
	 * @author Roumuald
	 */
	
	private EmailService emailService;

	@Autowired
	public EmailControlleur(EmailService emailService) {
		super();
		this.emailService = emailService;
	}
	
	@RequestMapping(method = RequestMethod.POST, path ="/envoyer-email")
    public void envoyerEmail(@RequestBody EmailRequest emailRequest) {
        String expediteur = emailRequest.getExpediteur();
        String destinataire = emailRequest.getDestinataire();
        String sujet = emailRequest.getSujet();
        String contenu = emailRequest.getContenu();
        
        emailService.envoyerEmail(expediteur, destinataire, sujet, contenu);
    }

}
