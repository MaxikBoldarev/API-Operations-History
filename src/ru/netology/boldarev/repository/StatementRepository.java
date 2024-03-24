package ru.netology.boldarev.repository;

import ru.netology.boldarev.model.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementRepository {

    Map<Integer, List<Operation>> statements = new HashMap<>();

    public void add(Integer integer, List<Operation> list){
        statements.put(integer, list);
    }

    public Map<Integer, List<Operation>> getStatements(){
        return statements;
    }

    public void setStatements(Map<Integer, List<Operation>> statements){
        this.statements = statements;
    }
}
