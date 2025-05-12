package com.java.rest.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate dueDate;
    private boolean completed;

    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

//    @PrePersist
//    public void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
}

