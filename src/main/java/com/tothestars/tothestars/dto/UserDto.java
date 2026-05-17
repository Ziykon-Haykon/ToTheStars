package com.tothestars.tothestars.dto;

import com.tothestars.tothestars.entity.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String avatarUrl;

    private String bio;

    private String timezone;

    private Role role;

    private Boolean enabled;

    private LocalDateTime createdAt;
}
