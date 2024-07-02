package com.tujuhsembilan.onlineshop.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.onlineshop.model.Orders;
import com.tujuhsembilan.onlineshop.service.OrdersService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/api/reports")
public class OrderReportController {
    @Autowired
    private OrdersService ordersService;
    
    @GetMapping("/orders")
    public ResponseEntity<InputStreamResource> downloadOrderReport() throws JRException {
        List<Orders> orders = ordersService.findAll();
        
        // Load template file
        JasperReport jasperReport = JasperCompileManager.compileReport("path/to/order_report_template.jrxml");
        
        // Prepare data source
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
        
        // Prepare parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Your Name");
        
        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        
        // Export the report to a PDF file
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        
        // Create input stream resource for response
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=orders_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}

