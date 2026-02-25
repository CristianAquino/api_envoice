package com.envoice.api_envoice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvoiceController {

    @GetMapping()
    private String gretting(){
        return "grettings";
    }
}
