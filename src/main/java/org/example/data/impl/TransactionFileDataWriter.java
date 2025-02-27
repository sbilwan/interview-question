package org.example.data.impl;

import org.example.data.TransactionDataWriter;
import org.example.models.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TransactionFileDataWriter implements TransactionDataWriter {

    private static final String TRANSACTION_CSV_FILE = "transaction_store.csv";

    @Override
    public void writeTransactions(List<Transaction> transactions) {
        Path path = Path.of(TRANSACTION_CSV_FILE);

        List<String> txs = transactions
                .stream()
                .map(Transaction::toCSV)
                .toList();

        try {
            Files.write(path, txs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTransaction(Transaction transaction) {
        // no op
    }
}
