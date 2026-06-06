package com.virtusa.FraudRuleChecker.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ExcelReaderService {

    public List<ExcelTransactionDTO> readExcel(
            MultipartFile file)
            throws IOException {

        List<ExcelTransactionDTO> transactions =
                new ArrayList<>();

        Workbook workbook =
                new XSSFWorkbook(file.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);

        for(int i = 1 ; i <= sheet.getLastRowNum() ; i++) {

            Row row = sheet.getRow(i);

            ExcelTransactionDTO dto =
                    ExcelTransactionDTO.builder()
                            .customerId(
                                    (long) row.getCell(0)
                                            .getNumericCellValue())
                            .amount(
                                    row.getCell(1)
                                            .getNumericCellValue())
                            .payee(
                                    row.getCell(2)
                                            .getStringCellValue())
                            .timestamp(
                                    row.getCell(3)
                                            .getLocalDateTimeCellValue())
                            .transactionCity(
                                    row.getCell(4)
                                            .getStringCellValue())
                            .build();

            transactions.add(dto);
        }

        workbook.close();

        return transactions;
    }
}
