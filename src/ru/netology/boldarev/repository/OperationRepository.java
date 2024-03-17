package ru.netology.boldarev.repository;

import ru.netology.boldarev.exception.CustomerOperationOutOfBoundException;
import ru.netology.boldarev.service.ConsolePrintable;
import ru.netology.boldarev.model.Operation;

public class OperationRepository implements ConsolePrintable {
    private int operationId = 1;

    private static int[][] statement = new int[100][100];

    private static Operation[] operations = new Operation[10000];

    public void addOperation(Operation operation, int customerId) throws CustomerOperationOutOfBoundException {
        if (operationId == 0) {
            for (Operation operation1 : operations) {
                if (operation1 != null) {
                    operationId++;
                }
            }
        }
        if (operationId == 9999) {
            System.out.println("Репозиторий заполнен");
        } else {
            try {
                Operation operationsId = new Operation(operationId, operation);
                operations[operationId] = operationsId;
                for (int i = 0; i < statement.length; i++) {
                    if (statement[customerId][i] == 0) {
                        statement[customerId][i] = operationId;
                        operationId++;
                        break;
                    }
                }
            } catch (CustomerOperationOutOfBoundException e) {
                System.out.println(new CustomerOperationOutOfBoundException(customerId, operationId).getMessage());
            }
        }
    }

    @Override
    public void print() {
        for (Operation operation : operations) {
            if (operation == null) {
                break;
            } else {
                System.out.println(operation);
            }
        }
    }

    public Operation[] getOperationsCustomer(int clientId) {
        Operation[] operations1 = new Operation[100];
        int count1 = 0;
        for (int i = 0; i < operations.length; i++) {
            Operation operation = operations[i];
            if (operation != null) {
                int id = operation.getId();
                for (int j = 0; j < operations1.length; j++) {
                    int opId = statement[clientId][j];
                    if (id == opId && opId != 0) {
                        operations1[count1] = operation;
                        count1++;
                    }
                }
            }
        }
        return operations1;
    }

    public void printOperation(Operation[] operationsCustomer) {
        for (Operation operation : operationsCustomer) {
            if (operation == null) {
                break;
            } else {
                System.out.println(operation);
            }
        }
    }

    public int[][] getStatement() {
        return statement;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public void setOperation(Operation[] operations) {
        OperationRepository.operations = operations;
    }

    public void setStatement(int[][] statement) {
        OperationRepository.statement = statement;
    }
}
