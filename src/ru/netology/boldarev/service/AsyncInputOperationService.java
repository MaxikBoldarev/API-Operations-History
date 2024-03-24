package ru.netology.boldarev.service;

import ru.netology.boldarev.model.Operation;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncInputOperationService {
    private final OperationService operationService;

    public AsyncInputOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    private Queue<Operation> queue = new LinkedList<>();

    public boolean offerOperation(Operation operation) {
        return queue.offer(operation);
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();
            if (operation == null) {
                try {
                    Thread.sleep(1_0000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation:" + operation);
                operationService.addOperation(operation);
            }
        }
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread(this::processQueue);
        t.start();
    }
}
