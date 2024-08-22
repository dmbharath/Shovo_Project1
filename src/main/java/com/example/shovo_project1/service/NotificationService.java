package com.example.shovo_project1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Notifications;
import com.example.shovo_project1.repository.NotificationsRepository;

@Service
public class NotificationService 
{
    @Autowired
    private NotificationsRepository notificationsRepository;

    public List<Notifications> getAllNotifications()
    {
        return notificationsRepository.findAll();
    }

    public Notifications getNotificationsById(Long id)throws ResourceNotFoundException
    {
        return notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications not found with id : "+id));
    }

    public Notifications createNotifications(Notifications notifications)
    {
        return notificationsRepository.save(notifications);
    }

    public Notifications updateNotifications(Long id, Notifications notificationsDetails) throws ResourceNotFoundException
    {
        Notifications notifications = notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications not found with the id : "+id));
        notifications.setReadMessage(notificationsDetails.getReadMessage());
        notifications.setTypeMessage(notificationsDetails.getTypeMessage());

        return notificationsRepository.save(notifications);
    }

    public void deleteNotifications(Long id) throws ResourceNotFoundException
    {
        Notifications notifications = notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications are not found with id : "+id));
        notificationsRepository.delete(notifications);
    }
}
