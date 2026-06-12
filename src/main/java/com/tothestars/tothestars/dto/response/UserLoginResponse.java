package com.tothestars.tothestars.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {
    private Long id;
    private String email;
    private String token;

}
