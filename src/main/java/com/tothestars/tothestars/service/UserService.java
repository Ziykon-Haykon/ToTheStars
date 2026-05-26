package com.tothestars.tothestars.service;

import com.tothestars.tothestars.UserMapper;
import com.tothestars.tothestars.dto.request.UserRequest;
import com.tothestars.tothestars.dto.response.UserResponse;
import com.tothestars.tothestars.entity.User;
import com.tothestars.tothestars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }
}
