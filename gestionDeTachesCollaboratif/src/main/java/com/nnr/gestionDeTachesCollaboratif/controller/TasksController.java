package com.nnr.gestionDeTachesCollaboratif.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.gestionDeTachesCollaboratif.model.AttributionTasks;
import com.nnr.gestionDeTachesCollaboratif.model.Files;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;
import com.nnr.gestionDeTachesCollaboratif.service.InterfaceTasks;

@RestController
@CrossOrigin("*")
public class TasksController {
	/**
	 * @author Roumuald
	 */
	
	private InterfaceTasks interfaceTasks;

	public TasksController(InterfaceTasks interfaceTasks) {
		super();
		this.interfaceTasks = interfaceTasks;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/newTasks")
	public Tasks newTask(Tasks task) {
		return interfaceTasks.newTask(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deleteTasks")
	public void deleteTask(Long idTask) {
		interfaceTasks.deleteTask(idTask);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateTasks")
	public Tasks updateTask(Tasks newTask, Long idTask) {
		return interfaceTasks.updateTask(newTask, idTask);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/attributeTaskToUsers/{idTask}/{idUser}")
    public ResponseEntity<String> attributeTaskToUsers(@RequestBody AttributionTasks attributeTask, @PathVariable Long idTask, @PathVariable Long idUser) {
        interfaceTasks.attributeTaskToUsers(attributeTask, idTask, idUser);
        return ResponseEntity.ok("Tache attribuee avec success !!!");
    }
	
	@RequestMapping(method = RequestMethod.POST, path = "/addFileToTask/{idTask}/")
    public ResponseEntity<String> addFileToTask(@RequestBody Files files, @PathVariable Long idTask) {
        interfaceTasks.addFileToTask(files, idTask);
        return ResponseEntity.ok("Fichier ajoute a la Tache avec success !!!");
    }

}
