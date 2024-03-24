package ru.netology.boldarev.service;

import ru.netology.boldarev.exception.OperationRuntimeException;
import ru.netology.boldarev.model.Operation;

import java.util.List;

import static ru.netology.boldarev.service.IOService.operationStorageService;
import static ru.netology.boldarev.service.IOService.statementService;

public class OperationService {

    private int operationId = 0;

    public int countId() {
        if (operationId == 0) {
            List<Operation> listOperations = operationStorageService.getAll();
            for (Operation oper : listOperations) {
                if (oper != null) {
                    operationId++;
                }
            }
            return operationId;
        }
        return 0;
    }

    public void addOperation(Operation operation) throws OperationRuntimeException {
        try {
            operationStorageService.add(operation);
        } catch (OperationRuntimeException e) {
            System.out.println("Ошибка добавления получателя");
        }
    }

    public List<Operation> getOperationsCustomer(int clientId) {
        return statementService.operationByCustomer(clientId);
    }

    public List<Operation> getAll() {
        return operationStorageService.getAll();
    }

}
