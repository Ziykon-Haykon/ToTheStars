package com.tothestars.tothestars.controller;

import com.tothestars.tothestars.dto.request.UserRequest;
import com.tothestars.tothestars.dto.response.UserLoginResponse;
import com.tothestars.tothestars.dto.response.UserRegisterResponse;
import com.tothestars.tothestars.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterResponse register(@RequestBody UserRequest userRequest) {
        return userService.register(userRequest);
    }

    @GetMapping("/getAll")
    public List<UserRegisterResponse> getAll() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserRequest request) {
        return userService.login(request);
    }
}
