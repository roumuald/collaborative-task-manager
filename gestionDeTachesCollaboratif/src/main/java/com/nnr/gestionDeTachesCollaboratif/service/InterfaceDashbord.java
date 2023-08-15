package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.List;

import com.nnr.gestionDeTachesCollaboratif.model.Projet;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;

public interface InterfaceDashbord {
	
	public List<Projet> getAllProgressProjet();
	
	public List<Projet> getAllFinishedProjet();
	
	public List<Tasks> getAllTodoTasks();
	
	public List<Tasks> getAllFinishedTasks();
	
	public List<Tasks> getAllProgressTasks();
	
	public double getStatisticFinishedProjet();
	
	public double getStatisticFinishedTasksForProjet(Long idProjet);

}
