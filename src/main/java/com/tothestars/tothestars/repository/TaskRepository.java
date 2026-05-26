package com.tothestars.tothestars.repository;

import com.tothestars.tothestars.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
