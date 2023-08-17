package com.nnr.gestionDeTachesCollaboratif.notification;

import javax.management.Notification;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	 private SimpMessagingTemplate messagingTemplate;

	public NotificationService(SimpMessagingTemplate messagingTemplate) {
		super();
		this.messagingTemplate = messagingTemplate;
	}
	 
	public void sendNotification(String destination, Notification notification) {
        messagingTemplate.convertAndSend("/topic/" + destination, notification);
    }

}
