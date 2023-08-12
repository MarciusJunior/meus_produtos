package com.meus_produtos_api.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutosDto {

    private String id;
    private String name;
    private String description;
    private int quantity;
    private Double price;
}
