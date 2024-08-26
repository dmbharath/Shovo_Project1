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
import com.example.shovo_project1.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController 
{
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notifications> getAllNotifications()
    {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    public Notifications createNotifications(@RequestBody Notifications notifications)
    {
        return notificationService.createNotifications(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationsById(@PathVariable Long id)throws ResourceNotFoundException
    {
        Notifications notifications = notificationService.getNotificationsById(id);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notifications> updateNotifications(@PathVariable Long id, @RequestBody Notifications notificationsDetails) throws ResourceNotFoundException
    {
        Notifications notifications = notificationService.updateNotifications(id, notificationsDetails);
        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotifications(@PathVariable Long id) throws ResourceNotFoundException
    {
        notificationService.deleteNotifications(id);
        return ResponseEntity.noContent().build();
    }
}
