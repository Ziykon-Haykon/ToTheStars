package com.tothestars.tothestars.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequest {

    @Size(min = 3, max = 50)
    private String username;

    @Size(max = 500)
    private String bio;

    private String avatarUrl;

    private String timezone;
}
