package com.tothestars.tothestars.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean isDone;
    private Long userId;
}
