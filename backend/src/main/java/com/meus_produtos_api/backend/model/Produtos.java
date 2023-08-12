package com.meus_produtos_api.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {

    @Id
    private String id;
    private String name;
    private String description;
    private int quantity;
    private Double price;

    private String userId;

}
