package oop.testDrivenDevelopment.src.main.java;

public interface Transaction {

    int getId();
    void setStatus(TransactionStatus status);
    TransactionStatus getStatus();
    double getAmount();

    String getFrom();

    String getTo();
}
