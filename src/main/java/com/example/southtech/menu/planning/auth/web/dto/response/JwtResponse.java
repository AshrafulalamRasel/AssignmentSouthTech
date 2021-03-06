package com.example.southtech.menu.planning.auth.web.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private String token;

    private String type = "Bearer";

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }


}
