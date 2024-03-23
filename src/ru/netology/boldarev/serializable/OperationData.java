package ru.netology.boldarev.serializable;

import ru.netology.boldarev.model.Customer;
import ru.netology.boldarev.model.Operation;
import ru.netology.boldarev.model.Statement;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class OperationData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Operation> operationList;
    private final List<Customer> customerList;
    private final List<Statement> statementList;

    public OperationData(List<Operation> operationList, List<Customer> customerList, List<Statement> statementList) {
        this.customerList = customerList;
        this.operationList = operationList;
        this.statementList = statementList;
    }


    public List<Operation> getOperations() {
        return operationList;
    }

    public List<Customer> getCustomers() {
        return customerList;
    }

    public List<Statement> getStatement() {
        return statementList;
    }

    @Override
    public String toString() {
        return "Customer: " + customerList + '\n' +
                "Operations: " + operationList + '\n' +
                "Statement: " + statementList;
    }
}
