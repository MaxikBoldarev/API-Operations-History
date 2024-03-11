package ru.netology.boldarev.repository;

import ru.netology.boldarev.exception.CustomerOperationOutOfBoundException;
import ru.netology.boldarev.service.ConsolePrintable;
import ru.netology.boldarev.model.Operation;

public class OperationRepository implements ConsolePrintable {
    private static int operationId = 1;

    private static int count = 0;

    public static int[][] statement = new int[100][100];

    static Operation[] operations = new Operation[100];

    public void addOperation(Operation operation, int customerId) throws CustomerOperationOutOfBoundException{
        if (count == 99) {
            System.out.println("Репозиторий заполнен");
        } else {
            try {
                Operation operationsId = new Operation(operationId, operation);
                operations[count] = operationsId;
                statement[customerId][count] = operationId;
                operationId++;
                count++;
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

    public static Operation[] getOperations(int clientId) {
        Operation[] operations1 = new Operation[100];
        int count1 = 0;
        for (int i = 0; i < statement.length; i++) {
            Operation operation = operations[i];
            if (operation != null) {
                if (operation.getId() == statement[clientId][i]) {
                    operations1[count1] = operation;
                    count1++;
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
}
