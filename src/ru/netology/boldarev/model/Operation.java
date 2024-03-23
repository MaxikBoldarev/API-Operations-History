package ru.netology.boldarev.model;

import java.io.Serializable;

public class Operation implements Serializable {

    private double amount;
    private int date;

    private int id;

    public Operation(int id, double amount, int date) {
        this.id = id;
        this.amount = amount;
        if (date < 1 || date > 30) {
            this.date = 1;
        } else {
            this.date = date;
        }
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
