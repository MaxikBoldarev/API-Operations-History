package ru.netology.boldarev.service;

import ru.netology.boldarev.model.Statement;
import ru.netology.boldarev.repository.StatementRepository;

import java.util.ArrayList;
import java.util.List;

public class StatementService {
    private static final StatementRepository statementRepository = new StatementRepository();

    public void addId(int customerId, int operationId) {
        Statement statement = new Statement(customerId, operationId);
        statementRepository.add(statement);
    }

    public List<Integer> operationByCustomer(int customerId) {
        List<Integer> operationId = new ArrayList<>();
        List<Statement> statementList = statementRepository.getStatements();
        for (Statement statement : statementList) {
            if (statement.getCustomerId() == customerId) {
                operationId.add(statement.getOperationId());
            }
        }
        return operationId;
    }

    public List<Statement> getAllStatement(){
        return statementRepository.getStatements();
    }

    public void setStatementRepository(List<Statement> statementList){
        statementRepository.setStatements(statementList);
    }
}
