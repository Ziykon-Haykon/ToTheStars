package com.tothestars.tothestars.service;

import com.tothestars.tothestars.dto.response.UserLoginResponse;
import com.tothestars.tothestars.mapper.UserMapper;
import com.tothestars.tothestars.dto.request.UserRequest;
import com.tothestars.tothestars.dto.response.UserRegisterResponse;
import com.tothestars.tothestars.entity.User;
import com.tothestars.tothestars.exception.ResourceNotFoundException;
import com.tothestars.tothestars.exception.WrongPasswordException;
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
    private final JwtService jwtService;

    public UserRegisterResponse register(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserLoginResponse login(UserRequest request) {
        var user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        }

        var token = jwtService.generateToker(user.getEmail());

        return userMapper.toResponse(user, token);
    }

    public List<UserRegisterResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }
}
