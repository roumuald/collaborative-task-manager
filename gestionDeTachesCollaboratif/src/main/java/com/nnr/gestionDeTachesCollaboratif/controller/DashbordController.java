package com.nnr.gestionDeTachesCollaboratif.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnr.gestionDeTachesCollaboratif.model.Projet;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;
import com.nnr.gestionDeTachesCollaboratif.service.InterfaceDashbord;

@RestController
@CrossOrigin("*")
public class DashbordController {
	
	private InterfaceDashbord interfaceDashbord;

	public DashbordController(InterfaceDashbord interfaceDashbord) {
		super();
		this.interfaceDashbord = interfaceDashbord;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allProgressProjet")
	public List<Projet> getAllProgressProjet(){
		return interfaceDashbord.getAllProgressProjet();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allFinishedProjet")
	public List<Projet> getAllFinishedProjet(){
		return interfaceDashbord.getAllFinishedProjet();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allTodoTasks")
	public List<Tasks> getAllTodoTasks(){
		return interfaceDashbord.getAllTodoTasks();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allFinishedTasks")
	public List<Tasks> getAllFinishedTasks(){
		return interfaceDashbord.getAllFinishedTasks();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/allProgressTasks")
	public List<Tasks> getAllProgressTasks(){
		return interfaceDashbord.getAllProgressTasks();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getStatisticFinishedProjet")
	public double getStatisticFinishedProjet() {
		return interfaceDashbord.getStatisticFinishedProjet();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getStatisticFinishedTasksForProjet/{idProjet}")
	public double getStatisticFinishedTasksForProjet(@PathVariable Long idProjet) {
		return interfaceDashbord.getStatisticFinishedTasksForProjet(idProjet);
	}

}
