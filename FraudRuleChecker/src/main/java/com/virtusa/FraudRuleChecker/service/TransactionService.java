package com.virtusa.FraudRuleChecker.service;

import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



import com.virtusa.FraudRuleChecker.dto.ExcelTransactionDTO;
import com.virtusa.FraudRuleChecker.dto.TransactionResponseDTO;
import com.virtusa.FraudRuleChecker.entity.Customer;
import com.virtusa.FraudRuleChecker.entity.Transaction;
import com.virtusa.FraudRuleChecker.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ExcelReaderService excelReaderService;
    private final FraudDroolsService fraudDroolsService;
    private final CustomerRepository customerRepository;

    public List<TransactionResponseDTO> processExcel(
            MultipartFile file)
            throws Exception {

        List<ExcelTransactionDTO> excelRows =
                excelReaderService.readExcel(file);

        List<TransactionResponseDTO> response =
                new ArrayList<>();

        for(ExcelTransactionDTO row : excelRows) {

            Customer customer =
                    customerRepository.findById(
                                    row.getCustomerId())
                            .orElseThrow();

            Transaction transaction =
                    Transaction.builder()
                            .customer(customer)
                            .amount(row.getAmount())
                            .payee(row.getPayee())
                            .timestamp(row.getTimestamp())
                            .transactionCity(
                                    row.getTransactionCity())
                            .build();

            Transaction saved =
                    fraudDroolsService
                            .evaluateAndSave(transaction);

            response.add(
                    TransactionResponseDTO.builder()
                            .transactionId(saved.getId())
                            .amount(saved.getAmount())
                            .riskScore(saved.getRiskScore())
                            .decision(saved.getDecision())
                            .build()
            );
        }

        return response;
    }
}