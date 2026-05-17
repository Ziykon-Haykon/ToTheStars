package com.tothestars.tothestars.dto.request;

import com.tothestars.tothestars.entity.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateGoalRequest {

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 2000)
    private String description;

    @NotNull
    private Integer targetValue;

    private String unit;

    private Priority priority;

    private LocalDate deadline;

    private String color;

    private String icon;
}
