package com.tothestars.tothestars.service;

import com.tothestars.tothestars.dto.request.TaskPatchRequest;
import com.tothestars.tothestars.dto.request.TaskRequest;
import com.tothestars.tothestars.dto.response.TaskResponse;
import com.tothestars.tothestars.entity.Task;
import com.tothestars.tothestars.exception.ResourceNotFoundException;
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
                () -> new ResourceNotFoundException("User not found"));
        var task = new Task();
        task.setDescription(request.getDescription());
        task.setUser(user);
        task.setName(request.getName());
        task.setIsDone(request.getIsDone());
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public TaskResponse patchTask(Long id, TaskPatchRequest request) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        if (request.name != null) {
            task.setName(request.getName());
        }
        if (request.isDone != null) {
            task.setIsDone(request.getIsDone());
        }
        if (request.description != null) {
            task.setDescription(request.getDescription());
        }
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    public TaskResponse getTask(Long id) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        return taskMapper.toDto(task);
    }

    public List<TaskResponse> getAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).toList();
    }

    public void deleteTask(Long id) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        taskRepository.delete(task);
    }
}
