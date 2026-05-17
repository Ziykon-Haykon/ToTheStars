package com.tothestars.tothestars.mapper;

import com.tothestars.tothestars.entity.Goal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class GoalMapper {
    Goal toEntity(CraetedGoalRequset requset);
    GoalDto toDto(Goal goal);
}
