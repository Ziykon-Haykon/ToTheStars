package com.tothestars.tothestars.service;

import com.tothestars.tothestars.dto.request.TaskRequest;
import com.tothestars.tothestars.dto.response.TaskResponse;
import com.tothestars.tothestars.entity.Task;
import com.tothestars.tothestars.mapper.TaskMapper;
import com.tothestars.tothestars.repository.TaskRepository;
import com.tothestars.tothestars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponse createTask(TaskRequest request) {
        var user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new RuntimeException("User not find"));
        var task = new Task();
        task.setDescription(request.getDescription());
        task.setUser(user);
        task.setName(request.getName());
        task.setIsDone(request.getIsDone());
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public List<TaskResponse> getAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).toList();
    }
}
