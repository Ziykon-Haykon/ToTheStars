package com.tothestars.tothestars.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskPatchRequest {
    public String name;
    public String description;
    public Boolean isDone;
}
