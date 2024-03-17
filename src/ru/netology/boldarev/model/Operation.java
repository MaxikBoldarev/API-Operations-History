package ru.netology.boldarev.model;

import java.io.Serializable;

public class Operation implements Serializable {

    private double amount;
    private int date;

    private int id;

    public Operation(int id, Operation operation) {
        this.id = id;
        this.date = operation.getDate();
        this.amount = operation.getAmount();
    }

    public Operation(double amount, int date) {
        this.amount = amount;
        if (date < 1 || date > 30) {
            this.date = 1;
        } else {
            this.date = date;
        }
    }


    public double getAmount() {
        return amount;
    }

    public void setSum(double sum) {
        this.amount = sum;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "amount=" + amount +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
