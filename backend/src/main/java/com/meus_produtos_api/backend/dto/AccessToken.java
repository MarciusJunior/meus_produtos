package com.meus_produtos_api.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessToken {

    private String accessToken;
    private String id;
    private String name;
    private String email;

}
