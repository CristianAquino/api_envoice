package com.envoice.api_envoice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvoiceModel {
    private ClientModel client;
    private List<ProductModel> products;
}
