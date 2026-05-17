package com.tothestars.tothestars.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatedGoalRequest {
    private String title;
    private String description;
    private Integer targetValue;
    private LocalDate deadline;
}
