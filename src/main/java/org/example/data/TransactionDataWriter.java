package org.example.data;

import org.example.models.Transaction;

import java.util.List;

public interface TransactionDataWriter {

    void writeTransactions(List<Transaction> transactions);

    void writeTransaction(Transaction transaction);
}
