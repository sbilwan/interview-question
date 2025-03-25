package org.example.models;

import java.time.LocalDate;

public class Transaction {

    private final String transactionId;
    private final String senderId;
    private final String receiverId;
    private final Double amount;
    private final LocalDate date;

    public Transaction(String transactionId, String senderId, String receiverId, Double amount , LocalDate date) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }


    public String getSenderId() {
        return senderId;
    }


    public Double getAmount() {
        return amount;
    }


    public LocalDate getDate() {
        return date;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String toCSV() {
        return transactionId + "," + senderId + "," + receiverId + "," + amount + "," + date.toString();
    }

    public static Transaction fromCSV(String line) {
        String[] splitLine = line.split(",");
        return new Transaction(splitLine[0], splitLine[1], splitLine[2], Double.valueOf(splitLine[3]), LocalDate.parse(splitLine[4]));
    }



}
