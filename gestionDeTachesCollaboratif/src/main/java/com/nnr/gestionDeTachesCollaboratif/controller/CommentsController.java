package com.nnr.gestionDeTachesCollaboratif.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.gestionDeTachesCollaboratif.model.Comments;
import com.nnr.gestionDeTachesCollaboratif.service.InterfaceComments;

@RestController
@CrossOrigin("*")
public class CommentsController {

	/**
	 * @author Roumuald
	 */
	
	private InterfaceComments interfaceComments;

	public CommentsController(InterfaceComments interfaceComments) {
		super();
		this.interfaceComments = interfaceComments;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/newComment/{idUser}/{idTask}")
	public Comments newComment(@RequestBody Comments comment, @PathVariable Long idUser, @PathVariable Long idTask) {
		return interfaceComments.newComment(comment, idUser, idTask);
	}
	
}
