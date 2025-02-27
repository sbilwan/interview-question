package org.example;

import org.example.analysis.TransactionAnalysis;
import org.example.data.impl.TransactionFileDataReader;
import org.example.data.impl.TransactionFileDataWriter;
import org.example.models.Transaction;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("... Tx Program ...");
        TransactionAnalysis analysis = new TransactionAnalysis(prepWork());
        //analysis.printTotalAmountPerCustomer();
        analysis.printTop3SpendersInDescendingOrder();
    }

    private static List<Transaction> prepWork() {
        new TransactionFileDataWriter().writeTransactions(populateTxs());
        return new TransactionFileDataReader().readAllTransactions();
    }

    private static List<Transaction> populateTxs() {
        Transaction t1 = new Transaction("0111","AA", 200.10d, LocalDate.of(2024, 1, 1));
        Transaction t2 = new Transaction("0112","AB", 100d, LocalDate.of(2024, 1, 12));
        Transaction t3 = new Transaction("0113","AC", 123.10d, LocalDate.of(2024, 3, 3));
        Transaction t4 = new Transaction("0114","AD", 311d, LocalDate.of(2024, 4, 17));
        Transaction t5 = new Transaction("0115","AE", 150d, LocalDate.of(2024, 5, 10));
        Transaction t6 = new Transaction("0116","AF", 250d, LocalDate.of(2024, 6, 21));
        Transaction t7 = new Transaction("0117","AA", 310d, LocalDate.of(2024, 7, 2));
        Transaction t8 = new Transaction("0118","AD", 123.67d, LocalDate.of(2024, 8, 29));
        return List.of(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}