package com.envoice.api_envoice.Controller;

import com.envoice.api_envoice.Model.EnvoiceModel;
import com.envoice.api_envoice.Service.Report;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EnvoiceController {

    private final Report report;

    @GetMapping()
    private String gretting() {
        return "grettings";
    }

    @PostMapping(value = "report", produces = MediaType.APPLICATION_PDF_VALUE)
    private ResponseEntity<byte[]> genereteReport(@RequestBody EnvoiceModel envoice) {
        byte[] reporte = report.reportTest(envoice);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition
                        .inline()
                        .filename("report.pdf")
                        .build()
        );
        return new ResponseEntity<>(reporte, headers, HttpStatus.OK);
    }
}
