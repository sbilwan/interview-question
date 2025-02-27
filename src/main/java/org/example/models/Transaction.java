package org.example.models;

import java.time.LocalDate;

public class Transaction {

    private String transactionId;
    private String customerId;
    private Double amount;
    private LocalDate date;

    public Transaction(String transactionId, String customerId, Double amount , LocalDate date) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String toCSV() {
        return transactionId + "," + customerId + "," + amount + "," + date.toString();
    }

    public static Transaction fromCSV(String line) {
        String[] splitLine = line.split(",");
        return new Transaction(splitLine[0], splitLine[1], Double.valueOf(splitLine[2]), LocalDate.parse(splitLine[3]));
    }

}
