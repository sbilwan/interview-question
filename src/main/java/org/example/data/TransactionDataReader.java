package org.example.data;

import org.example.models.Transaction;

import java.util.List;

public interface TransactionDataReader {
    List<Transaction> readAllTransactions();
    Transaction readTransaction(String transactionId);

}
