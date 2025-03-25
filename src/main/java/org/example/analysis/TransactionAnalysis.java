package org.example.analysis;

public interface TransactionAnalysis {

    void printTotalAmountPerSender();
    void printTop3SpendersInDescendingOrder();
    void printMonthOfHighestAmount();
    void printMonthOfMaximumTransactions();
    void printReceiverReceivingMaximumAmount();
    void printUsersWhoAreBothSendersAndReceivers();

}
