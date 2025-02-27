package org.example.data.impl;

import org.example.data.TransactionDataReader;
import org.example.models.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TransactionFileDataReader implements TransactionDataReader {
    private static final String TRANSACTION_CSV_FILE = "transaction_store.csv";
    @Override
    public List<Transaction> readAllTransactions() {
        Path path = Path.of(TRANSACTION_CSV_FILE);
        try {
            List<String> txs = Files.readAllLines(path);
            return txs.stream()
                    .map(Transaction::fromCSV)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction readTransaction(String transactionId) {
        return null;
    }
}
