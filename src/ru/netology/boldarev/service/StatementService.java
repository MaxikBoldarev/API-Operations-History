package ru.netology.boldarev.service;

import ru.netology.boldarev.model.Operation;
import ru.netology.boldarev.repository.StatementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatementService {
    private static final StatementRepository statementRepository = new StatementRepository();

    public void addId(int customerId, Operation operation) {
        Map<Integer, List<Operation>> statements = statementRepository.getStatements();
        if (statements.containsKey(customerId)) {
            List<Operation> list = statements.get(customerId);
            list.add(operation);
            statements.put(customerId, list);
            statementRepository.setStatements(statements);
        } else {
            List<Operation> list = new ArrayList<>();
            list.add(operation);
            statementRepository.add(customerId, list);
        }
    }

    public List<Operation> operationByCustomer(int customerId) {
        Map<Integer, List<Operation>> statements = statementRepository.getStatements();
        return statements.get(customerId);
    }

    public Map<Integer, List<Operation>> getAllStatement() {
        return statementRepository.getStatements();
    }

    public void setStatementRepository(Map<Integer, List<Operation>> listMap) {
        statementRepository.setStatements(listMap);
    }
}
