package com.tothestars.tothestars.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private Long userId;
    private String name;
    private String description;
    private Boolean isDone;
}
