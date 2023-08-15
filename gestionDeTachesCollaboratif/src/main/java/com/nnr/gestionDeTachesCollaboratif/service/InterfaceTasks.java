package com.nnr.gestionDeTachesCollaboratif.service;

import com.nnr.gestionDeTachesCollaboratif.model.AttributionTasks;
import com.nnr.gestionDeTachesCollaboratif.model.Files;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;

public interface InterfaceTasks {
	
	public Tasks newTask(Tasks task);
	
	public void deleteTask(Long idTask);
	
	public Tasks updateTask(Tasks newTask, Long idTask);
	
	public void attributeTaskToUsers(AttributionTasks attributeTask, Long idTask, Long idUser);
	
	public void addFileToTask(Files files, Long idTask);

}
