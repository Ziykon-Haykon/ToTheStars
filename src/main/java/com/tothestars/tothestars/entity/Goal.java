package com.tothestars.tothestars.entity;

import com.tothestars.tothestars.entity.enums.GoalStatus;
import com.tothestars.tothestars.entity.enums.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Table (name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private GoalStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private Integer targetValue;

    private Integer currentValue = 0;

    private String unit;

    private LocalDate deadline;

    private Boolean archived = false;

    private String color;

    private String icon;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "goal")
    List<GoalProgress> progressEntries = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
