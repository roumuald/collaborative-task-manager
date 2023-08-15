package com.nnr.gestionDeTachesCollaboratif.service;

import com.nnr.gestionDeTachesCollaboratif.model.Comments;

public interface InterfaceComments {
	
	public Comments newComment(Comments comment, Long idUser, Long idTask);

}
