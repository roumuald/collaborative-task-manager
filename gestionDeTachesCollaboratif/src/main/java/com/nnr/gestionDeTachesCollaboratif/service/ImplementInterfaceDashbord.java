package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nnr.gestionDeTachesCollaboratif.enumerate.ProjetStatus;
import com.nnr.gestionDeTachesCollaboratif.enumerate.TaskStatus;
import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.Projet;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;
import com.nnr.gestionDeTachesCollaboratif.repository.ProjetRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.TasksRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ImplementInterfaceDashbord implements InterfaceDashbord{
	

	private ProjetRepository projetRepository;
	private TasksRepository tasksRepository;
	
	public ImplementInterfaceDashbord(ProjetRepository projetRepository, TasksRepository tasksRepository) {
		super();
		this.projetRepository = projetRepository;
		this.tasksRepository = tasksRepository;
	}

	@Override
	public List<Projet> getAllProgressProjet() {
		List<Projet> projetProgress = new ArrayList<>();
		List<Projet> projet = projetRepository.findAll();
		if(!projet.isEmpty()) {
			for(int i=0; i<projet.size(); i++) {
				if(projet.get(i).getStatus()==ProjetStatus.IN_PROGRESS) {
					projetProgress.add(projet.get(i));
				}
			}
			return projetProgress;
		}else {
			log.error("Aucun projet disponible en base de donnees");
			throw new GestionDeTachesCollaboratifException("Aucun projet disponible en base de donnees");
		}
	}

	@Override
	public List<Projet> getAllFinishedProjet() {
		List<Projet> projetFinished = new ArrayList<>();
		List<Projet> projet = projetRepository.findAll();
		if(!projet.isEmpty()) {
			for(int i=0; i<projet.size(); i++) {
				if(projet.get(i).getStatus()==ProjetStatus.FINISHED) {
					projetFinished.add(projet.get(i));
				}
			}
			return projetFinished;
		}else {
			log.error("Aucun projet disponible en base de donnees");
			throw new GestionDeTachesCollaboratifException("Aucun projet disponible en base de donnees");
		}
	}

	@Override
	public List<Tasks> getAllTodoTasks() {
		List<Tasks> tasksTodo = new ArrayList<>();
		List<Tasks> tasks = tasksRepository.findAll();
		if(!tasks.isEmpty()) {
			for(int i=0; i<tasks.size(); i++) {
				if(tasks.get(i).getStatus()==TaskStatus.TO_DO) {
					tasksTodo.add(tasks.get(i));
				}
			}
			return tasksTodo;
		}else {
			log.error("Aucune tache disponible en base de donnees");
			throw new GestionDeTachesCollaboratifException("Aucune tache disponible en base de donnees");
		}
	}

	@Override
	public List<Tasks> getAllFinishedTasks() {
		List<Tasks> tasksFinished = new ArrayList<>();
		List<Tasks> tasks = tasksRepository.findAll();
		if(!tasks.isEmpty()) {
			for(int i=0; i<tasks.size(); i++) {
				if(tasks.get(i).getStatus()==TaskStatus.FINISHED) {
					tasksFinished.add(tasks.get(i));
				}
			}
			return tasksFinished;
		}else {
			log.error("Aucune tache disponible en base de donnees");
			throw new GestionDeTachesCollaboratifException("Aucune tache disponible en base de donnees");
		}
	}

	@Override
	public List<Tasks> getAllProgressTasks() {
		List<Tasks> tasksProgress = new ArrayList<>();
		List<Tasks> task =  tasksRepository.findAll();
		if(!task.isEmpty()) {
			for(int i=0; i<task.size(); i++) {
				if(task.get(i).getStatus()==TaskStatus.IN_PROGRESS) {
						tasksProgress.add(task.get(i));
					}
				}
				return tasksProgress;
			}else {
				log.error("Aucune tache disponible en base de donnees");
				throw new GestionDeTachesCollaboratifException("Aucune tache disponible en base de donnees");
			}
	}

	@Override
	public double getStatisticFinishedProjet() {
		List<Projet> finishedProjet =  new ArrayList<>();
		List<Projet> projet = projetRepository.findAll();
		if(!projet.isEmpty()) {
			int totalProjet = projet.size();
			for(int i=0; i<projet.size(); i++) {
				if(projet.get(i).getStatus()==ProjetStatus.FINISHED) {
					finishedProjet.add(projet.get(i));
				}
			}
			int completedProjet = finishedProjet.size();
			return (completedProjet/totalProjet)*100;
		}else {
			return 0.0;
		}
	}

	@Override
	public double getStatisticFinishedTasksForProjet(Long idProjet) {
		List<Tasks> finishedTask =  new ArrayList<>();
		Optional<Projet> projet = projetRepository.findById(idProjet);
		if(projet.isPresent()) {
			List<Tasks> task = projet.get().getTasks();
			if(!task.isEmpty()) {
				int totalTasks = task.size();
				for(int i=0; i<task.size(); i++) {
					if(task.get(i).getStatus()==TaskStatus.FINISHED) {
						finishedTask.add(task.get(i));
					}
				}
				int completedTasks = finishedTask.size();
				return (completedTasks/totalTasks)*100;
			}else {
				return 0.0;
			}
		}else {
			return 0.0;
		}
	}
}
