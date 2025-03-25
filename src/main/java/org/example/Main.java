package org.example;

import org.example.analysis.TransactionReports;
import org.example.data.impl.TransactionFileDataReader;
import org.example.data.impl.TransactionFileDataWriter;
import org.example.models.Transaction;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("... Tx Program ...");
        TransactionReports analysis = new TransactionReports(prepWork());
        //analysis.printTotalAmountPerCustomer();
        //analysis.printTop3SpendersInDescendingOrder();
        //analysis.printReceiverReceivingMaximumAmount();
        analysis.printUsersWhoAreBothSendersAndReceivers();
    }

    private static List<Transaction> prepWork() {
        new TransactionFileDataWriter().writeTransactions(populateTxs());
        return new TransactionFileDataReader().readAllTransactions();
    }

    private static List<Transaction> populateTxs() {
        Transaction t1 = new Transaction("0111","AA", "MA", 200.10d, LocalDate.of(2024, 1, 1));
        Transaction t2 = new Transaction("0112","AB", "MB", 100d, LocalDate.of(2024, 1, 12));
        Transaction t3 = new Transaction("0113","AC", "MC", 123.10d, LocalDate.of(2024, 3, 3));
        Transaction t4 = new Transaction("0114","AD", "MD",311d, LocalDate.of(2024, 4, 17));
        Transaction t5 = new Transaction("0115","AE", "AC",150d, LocalDate.of(2024, 5, 10));
        Transaction t6 = new Transaction("0116","AF", "AC", 250d, LocalDate.of(2024, 6, 21));
        Transaction t7 = new Transaction("0117","AA", "ME", 310d, LocalDate.of(2024, 7, 2));
        Transaction t8 = new Transaction("0118","AD", "AE", 123.67d, LocalDate.of(2024, 8, 29));
        return List.of(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}