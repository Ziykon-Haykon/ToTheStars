package com.tothestars.tothestars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean enabled = true;

    private String avatarUrl;

    @Column(length = 500)
    private String bio;

    private String timezone;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "user")
    private List<Goal> goals = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Habit> habits = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notifcation> notifcations = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updateAt = LocalDateTime.now();
    }
}