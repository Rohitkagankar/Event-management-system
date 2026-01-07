package com.project.controllers;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.service.PdfService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pdf")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(@RequestBody String htmlContent) throws IOException {
        
    	byte[] pdfBytes = pdfService.convertHtmlToPdf(htmlContent);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
