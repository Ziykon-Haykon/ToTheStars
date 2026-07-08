package com.tothestars.tothestars.controller;

import com.tothestars.tothestars.dto.request.TaskPatchRequest;
import com.tothestars.tothestars.dto.request.TaskRequest;
import com.tothestars.tothestars.dto.response.TaskResponse;
import com.tothestars.tothestars.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public TaskResponse create(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping("/getAll")
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @PatchMapping("/{id}")
    public TaskResponse patchTask(@PathVariable Long id, @RequestBody TaskPatchRequest request) {
        return taskService.patchTask(id, request);
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
