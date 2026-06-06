package com.virtusa.FraudRuleChecker.controller;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(
            @RequestBody Transaction transaction) {

        return ResponseEntity.ok(
                transactionService.saveTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        return ResponseEntity.ok(
                transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                transactionService.getTransactionById(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(
            @RequestParam("\"C:\\Users\\VIRTUSA\\Downloads\\transactions.csv\"") MultipartFile file) {

        transactionService.uploadCsv(file);

        return ResponseEntity.ok(
                "CSV uploaded successfully");
    }

    @PostMapping("/analyze/{id}")
    public ResponseEntity<?> analyzeTransaction(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                transactionService.analyzeTransaction(id));
    }

    @PostMapping("/analyze-all")
    public ResponseEntity<?> analyzeAllTransactions() {

        return ResponseEntity.ok(
                transactionService.analyzeAllTransactions());
    }
}