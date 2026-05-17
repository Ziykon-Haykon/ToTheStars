package com.tothestars.tothestars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "goal_progress")
@Getter
@Setter
public class GoalProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;

    private String comment;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }
}