package com.envoice.api_envoice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    private String fullName;
    private String ruc;
    private String address;
}
