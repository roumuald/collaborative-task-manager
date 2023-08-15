package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.gestionDeTachesCollaboratif.enumerate.ProjetStatus;
import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.MemberProjet;
import com.nnr.gestionDeTachesCollaboratif.model.Projet;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.MemberProjetRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.ProjetRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ImplementInterfaceProjet implements InterfaceProjet{
	/**
	 * @author Roumuald
	 */
	
	private ProjetRepository projetRepository;
	private UsersRepository usersRepository;
	private MemberProjetRepository memberProjetRepository;
	
	public ImplementInterfaceProjet(ProjetRepository projetRepository, UsersRepository usersRepository,
			MemberProjetRepository memberProjetRepository) {
		super();
		this.projetRepository = projetRepository;
		this.usersRepository = usersRepository;
		this.memberProjetRepository = memberProjetRepository;
	}
	
	@Override
	public Projet newProjet(Projet projet, Long idUser) {
		Optional<Users> user = usersRepository.findById(idUser);
		if(user.isPresent()) {
			projet.setUsers(user.get());
			projet.setStatus(ProjetStatus.IN_PROGRESS);
			Projet projets = projetRepository.save(projet);
			return projets;
		}else {
			log.error("Impossible de creer un projet si vous n'etes pas administrateur");
			throw new GestionDeTachesCollaboratifException("Impossible de creer un projet si vous n'etes pas administrateur");
		}
	}

	@Override
	public void deleteProjet(Long idProjet) {
		Optional<Projet> projet = projetRepository.findById(idProjet);
		if(projet.isPresent()) {
			projetRepository.delete(projet.get());
		}else {
			log.error("Aucun projet en base de donnees avec l'identifiant"+" "+idProjet);
			throw new GestionDeTachesCollaboratifException("Aucun projet en base de donnees avec l'identifiant"+" "+idProjet);
		}
	}

	@Override
	public Projet updateProjet(Projet newProjet, Long idProjet, Long idUser) {
		Optional<Projet> projet = projetRepository.findById(idProjet);
		Optional<Users> user = usersRepository.findById(idUser);
		if(projet.isPresent()) {
			if(user.isPresent()) {
				projet.get().setId(newProjet.getId());
				projet.get().setDescription(newProjet.getDescription());
				projet.get().setName(newProjet.getName());
				projet.get().setStatus(newProjet.getStatus());
				projet.get().setUsers(newProjet.getUsers());
				return projetRepository.save(projet.get());
			}else {
				log.error("Impossible de creer un projet si vous n'etes pas administrateur");
				throw new GestionDeTachesCollaboratifException("Impossible de creer un projet si vous n'etes pas administrateur");
			}	
		}else {
			log.error("Aucun projet en base de donnees avec l'identifiant"+" "+idProjet);
			throw new GestionDeTachesCollaboratifException("Aucun projet en base de donnees avec l'identifiant"+" "+idProjet);
		}
	}

	@Override
	public void addUserToProjet(MemberProjet member, Long idProjet, Long idUser) {
		Optional<Projet> projet = projetRepository.findById(idProjet);
		Optional<Users> user = usersRepository.findById(idUser);
		if(projet.isPresent()&&user.isPresent()) {
			member.setProjet(projet.get());
			member.setUser(user.get());
			memberProjetRepository.save(member);
		}
	}

}
