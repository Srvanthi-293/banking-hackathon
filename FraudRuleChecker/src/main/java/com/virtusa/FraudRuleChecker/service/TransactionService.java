package com.virtusa.FraudRuleChecker.service;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found with id : " + id));
    }

    public String uploadCsv(MultipartFile file) {

        // CSV Parsing Logic
        // Read file and save transactions into DB

        return "CSV Uploaded Successfully";
    }

    public Transaction analyzeTransaction(Long id) {

        Transaction transaction = getTransactionById(id);

        int riskScore = 0;

        // Rule 1 - High Amount
        if (transaction.getAmount() > 50000) {
            riskScore += 30;
        }

        // Rule 2 - Odd Hour
        int hour = transaction.getTransactionDateTime().getHour();

        if (hour >= 1 && hour <= 4) {
            riskScore += 15;
        }

        transaction.setRiskScore(riskScore);

        if (riskScore <= 30) {
            transaction.setDecision("SAFE");
        } else if (riskScore <= 60) {
            transaction.setDecision("REVIEW");
        } else {
            transaction.setDecision("FRAUD");
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> analyzeAllTransactions() {

        List<Transaction> transactions =
                transactionRepository.findAll();

        transactions.forEach(txn -> {

            int riskScore = 0;

            if (txn.getAmount() > 50000) {
                riskScore += 30;
            }

            int hour = txn.getTransactionDateTime().getHour();

            if (hour >= 1 && hour <= 4) {
                riskScore += 15;
            }

            txn.setRiskScore(riskScore);

            if (riskScore <= 30) {
                txn.setDecision("SAFE");
            } else if (riskScore <= 60) {
                txn.setDecision("REVIEW");
            } else {
                txn.setDecision("FRAUD");
            }

        });

        return transactionRepository.saveAll(transactions);
    }
}