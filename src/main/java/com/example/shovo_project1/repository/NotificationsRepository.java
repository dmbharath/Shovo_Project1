package com.example.shovo_project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shovo_project1.model.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long>
{
    
}
