package com.tothestars.tothestars.mapper;

import com.tothestars.tothestars.dto.response.UserLoginResponse;
import com.tothestars.tothestars.dto.response.UserRegisterResponse;
import com.tothestars.tothestars.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRegisterResponse toDto(User user);
    UserLoginResponse toResponse(User user, String token);
}
