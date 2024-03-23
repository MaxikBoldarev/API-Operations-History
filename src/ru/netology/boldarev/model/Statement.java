package ru.netology.boldarev.model;

import java.io.Serializable;

public class Statement implements Serializable {

    private int customerId;
    private int operationId;

    public Statement(int customerId, int operationId) {
        this.customerId = customerId;
        this.operationId = operationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getOperationId() {
        return operationId;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "customerId=" + customerId +
                ", operationId=" + operationId +
                '}';
    }
}
