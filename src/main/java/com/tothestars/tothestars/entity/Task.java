package com.tothestars.tothestars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_done")
    private Boolean isDone;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
