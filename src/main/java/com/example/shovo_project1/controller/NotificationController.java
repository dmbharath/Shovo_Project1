package com.example.shovo_project1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shovo_project1.exception.ResourceNotFoundException;
import com.example.shovo_project1.model.Notifications;
import com.example.shovo_project1.repository.NotificationsRepository;

@RestController
@RequestMapping("/api/users")
public class NotificationController 
{
    @Autowired
    private NotificationsRepository notificationsRepository;

    @GetMapping
    public List<Notifications> getAllNotifications()
    {
        return notificationsRepository.findAll();
    }

    @PostMapping
    public Notifications createNotifications(@RequestBody Notifications notifications)
    {
        return notificationsRepository.save(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationsById(@PathVariable Long id)throws ResourceNotFoundException
    {
        Notifications notifications = notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications not found with the id : "+id));
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notifications> updateNotifications(@PathVariable Long id, @RequestBody Notifications notificationsDetails) throws ResourceNotFoundException
    {
        Notifications notifications = notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications not found with the id : "+id));
        notifications.setReadMessage(notificationsDetails.getReadMessage());
        notifications.setTypeMessage(notificationsDetails.getTypeMessage());

        Notifications updateNotifications = notificationsRepository.save(notifications);
        return ResponseEntity.ok(updateNotifications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notifications> deleteNotifications(@PathVariable Long id) throws ResourceNotFoundException
    {
        Notifications notifications = notificationsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Notifications are not found with id : "+id));
        notificationsRepository.delete(notifications);
        return ResponseEntity.noContent().build();
    }
}
