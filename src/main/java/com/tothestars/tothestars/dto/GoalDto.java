package com.tothestars.tothestars.dto;

import com.tothestars.tothestars.entity.enums.GoalStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoalDto {
    private Long id;
    private String title;
    private Integer progress;
    private GoalStatus status;
}
