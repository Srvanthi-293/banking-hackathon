package com.virtusa.FraudRuleChecker.controller;

import com.virtusa.FraudRuleChecker.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final TransactionService transactionService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcel(
            @RequestParam("file")
            MultipartFile file)
            throws Exception {

        return ResponseEntity.ok(
                transactionService.processExcel(file));
    }
}