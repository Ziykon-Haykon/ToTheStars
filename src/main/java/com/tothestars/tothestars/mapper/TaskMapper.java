package com.tothestars.tothestars.mapper;

import com.tothestars.tothestars.dto.response.TaskResponse;
import com.tothestars.tothestars.entity.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "user.id", target = "userId")
    TaskResponse toDto(Task task);
}
