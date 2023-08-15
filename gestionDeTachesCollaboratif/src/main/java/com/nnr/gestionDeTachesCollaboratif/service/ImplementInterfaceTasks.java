package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.gestionDeTachesCollaboratif.enumerate.TaskStatus;
import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.AttributionTasks;
import com.nnr.gestionDeTachesCollaboratif.model.Files;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.FilesRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.TasksRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceTasks implements InterfaceTasks{

	private TasksRepository tasksRepository;
	private UsersRepository userRepository;
	private FilesRepository filesRepository;

	public ImplementInterfaceTasks(TasksRepository tasksRepository, UsersRepository userRepository,
			FilesRepository filesRepository) {
		super();
		this.tasksRepository = tasksRepository;
		this.userRepository = userRepository;
		this.filesRepository=filesRepository;
	}

	@Override
	public Tasks newTask(Tasks task) {
		task.setStatus(TaskStatus.TO_DO);
		Tasks taskfinal = tasksRepository.save(task);
		return taskfinal;
	}

	@Override
	public void deleteTask(Long idTask) {
		Optional<Tasks> task = tasksRepository.findById(idTask);
		if(task.isPresent()) {
			tasksRepository.deleteById(idTask);
		}else {
			log.error("Aucune task disponible avec l'identifiant"+""+idTask);
			throw new GestionDeTachesCollaboratifException("Aucune task disponible avec l'identifiant"+""+idTask);
		}
	}

	@Override
	public Tasks updateTask(Tasks newTask, Long idTask) {
		Optional<Tasks> task = tasksRepository.findById(idTask);
		if(task.isPresent()) {
			task.get().setId(newTask.getId());
			task.get().setName(newTask.getName());
			task.get().setStatus(newTask.getStatus());
			
			return task.get();
		}else {
			log.error("Aucune task disponible avec l'identifiant"+""+idTask);
			throw new GestionDeTachesCollaboratifException("Aucune task disponible avec l'identifiant"+""+idTask);
		}
	}

	@Override
	public void attributeTaskToUsers(AttributionTasks attributeTask, Long idTask, Long idUser) {
		Optional<Tasks> task = tasksRepository.findById(idTask);
		Optional<Users> user = userRepository.findById(idTask);
		
		if(task.isPresent()&&user.isPresent()) {
			attributeTask.setTask(task.get());
			attributeTask.setUser(user.get());
		}else {
			log.error("Impossible d'attribuer la tache au membre car la tache ou le membre n'existe pas");
			throw new GestionDeTachesCollaboratifException("Impossible d'attribuer la tache au membre car la tache ou le membre n'existe pas");
		}
	}

	@Override
	public void addFileToTask(Files files, Long idTask) {
		Optional<Tasks> task = tasksRepository.findById(idTask);
		if(task.isPresent()) {
			files.setTask(task.get());
			//task.get().getFiles().add(files);
			filesRepository.save(files);
		}
	}

}
