package com.tothestars.tothestars.controller;

import com.tothestars.tothestars.dto.request.TaskRequest;
import com.tothestars.tothestars.dto.response.TaskResponse;
import com.tothestars.tothestars.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
