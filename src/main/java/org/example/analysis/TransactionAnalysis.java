package org.example.analysis;

import org.example.models.Transaction;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TransactionAnalysis {

    private final List<Transaction> transactions;

    public TransactionAnalysis(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void printTotalAmountPerCustomer() {

        Map<String, Double> grouped = transactions.stream().collect(groupingBy(Transaction::getCustomerId,
                summingDouble(Transaction::getAmount)));

        Set<Map.Entry<String, Double>> entries = grouped.entrySet();
        entries.forEach(System.out::println);

    }

    public void printTop3SpendersInDescendingOrder() {
        Stream<Map.Entry<String, Double>> top3Spenders = transactions.stream().collect(groupingBy(Transaction::getCustomerId,
                        summingDouble(Transaction::getAmount)))
                .entrySet().stream().sorted( (e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3);
        top3Spenders.forEach(System.out::println);
    }

    public void printMonthOfHighestAmount() {

    }

    public void printMonthOfMaximumTransactions() {

    }
}
