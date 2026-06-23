package com.envoice.api_envoice.Service.Impl;

import com.envoice.api_envoice.Model.ClientModel;
import com.envoice.api_envoice.Model.EnvoiceModel;
import com.envoice.api_envoice.Model.ProductModel;
import com.envoice.api_envoice.Model.TestModel;
import com.envoice.api_envoice.Service.Report;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportImpl implements Report {

    @Value("${empresa.nombre}")
    private String nombreEmpresa;

    @Value("${empresa.ruc}")
    private String rucEmpresa;

    @Value("${empresa.direccion}")
    private String direccionEmpresa;

    @Value("${empresa.telefono}")
    private String telefonoEmpresa;

    @Value("${pago.banco}")
    private String bancoPago;

    @Value("${pago.iban}")
    private String ibanPago;

    @Value("${pago.bic}")
    private String bicPago;

    @Override
    public byte[] reportTest(EnvoiceModel envoice) {
        ClientModel client = envoice.getClient();
        List<ProductModel> products = envoice.getProducts();
        Resource resource1 = new ClassPathResource("reports/EnvoiceReport.jrxml");
        Resource img = new ClassPathResource("images/logo.png");
        JasperReport jasperReport = null;
//        List<ProductModel> list = new ArrayList<>();

        try {
            jasperReport = JasperCompileManager.compileReport(resource1.getInputStream());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
            Map<String, Object> params = new HashMap<>();
            InputStream logo = img.getInputStream();
            params.put("logo", logo);
            params.put("nombreEmpresa",nombreEmpresa);
            params.put("rucEmpresa",rucEmpresa);
            params.put("direccionEmpresa",direccionEmpresa);
            params.put("telefonoEmpresa",telefonoEmpresa);
            params.put("bancoPago",bancoPago);
            params.put("ibanPago",ibanPago);
            params.put("bicPago",bicPago);
            params.put("datosCliente",client);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
            return pdf;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
