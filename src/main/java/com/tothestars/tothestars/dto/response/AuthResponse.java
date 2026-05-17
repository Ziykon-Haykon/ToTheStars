package com.tothestars.tothestars.dto.response;

import com.tothestars.tothestars.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {

    private String token;

    private UserDto user;
}
