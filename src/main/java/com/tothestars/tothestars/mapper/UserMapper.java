package com.tothestars.tothestars.mapper;

import com.tothestars.tothestars.dto.response.UserResponse;
import com.tothestars.tothestars.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toDto(User user);
}
