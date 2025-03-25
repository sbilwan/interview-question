package org.example.analysis;

import org.example.models.Transaction;

import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TransactionReports implements TransactionAnalysis{

    private final List<Transaction> transactions;

    public TransactionReports(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void printTotalAmountPerSender() {

        Map<String, Double> aMap = new HashMap<>();
        Map<String, Double> grouped = transactions.stream().collect(groupingBy(Transaction::getSenderId,
                summingDouble(Transaction::getAmount)));

        Set<Map.Entry<String, Double>> entries = grouped.entrySet();
        entries.forEach(System.out::println);

    }

    public void printTop3SpendersInDescendingOrder() {
        Stream<Map.Entry<String, Double>> top3Spenders = transactions.stream().collect(groupingBy(Transaction::getSenderId,
                        summingDouble(Transaction::getAmount)))
                .entrySet().stream().sorted( (e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3);
        top3Spenders.forEach(System.out::println);
    }

    public void printMonthOfHighestAmount() {

        Map<String, Double> map = new HashMap<>();
        Stream<Map.Entry<Month, Double>> limit = transactions.stream().collect(
                groupingBy(t -> t.getDate().getMonth(), summingDouble(Transaction::getAmount))
        ).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(1);
        limit.forEach(System.out::println);


    }

    public void printMonthOfMaximumTransactions() {
    }

    public void printReceiverReceivingMaximumAmount() {

        List<Map.Entry<String, Double>> receiverWithMaximumAmountReceived = transactions.stream().collect(
                groupingBy(Transaction::getReceiverId, summingDouble(Transaction::getAmount))
        ).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(1).toList();

        System.out.println(receiverWithMaximumAmountReceived);
    }

    public void printUsersWhoAreBothSendersAndReceivers() {
        ArrayList<String> distinctSenders = (ArrayList<String>) transactions.stream().map(Transaction::getSenderId).sorted().distinct().collect(toList());
        ArrayList<String> distinctReceivers  = (ArrayList<String>) transactions.stream().map(Transaction::getReceiverId).sorted().distinct().collect(toList());
        distinctSenders.retainAll(distinctReceivers);
        System.out.println(distinctSenders);


    }

}
