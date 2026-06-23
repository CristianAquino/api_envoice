package com.envoice.api_envoice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private Integer quantity;
}
