package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.Comments;
import com.nnr.gestionDeTachesCollaboratif.model.Tasks;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.CommentsRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.TasksRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceComments implements InterfaceComments{
	/**
	 * @author Roumuald
	 */
	
	private CommentsRepository commentRepository;
	private UsersRepository usersRepository;
	private TasksRepository tasksRepository;
	
	
	public ImplementInterfaceComments(CommentsRepository commentRepository, UsersRepository usersRepository,
			TasksRepository tasksRepository) {
		super();
		this.commentRepository = commentRepository;
		this.usersRepository = usersRepository;
		this.tasksRepository = tasksRepository;
	}

	@Override
	public Comments newComment(Comments comment, Long idUser, Long idTask) {
		Optional<Users> user = usersRepository.findById(idUser);
		Optional<Tasks> task = tasksRepository.findById(idTask);
		if(user.isPresent()&&task.isPresent()) {
			comment.setTask(task.get());
			comment.setUser(user.get());
			comment.setCreatedDate(new Date());
			Comments comments = commentRepository.save(comment);
			return comments;
		}else {
			log.error("Impossible de poster un nouveau message");
			throw new GestionDeTachesCollaboratifException("Impossible de poster un nouveau message");
		}
	}

}
