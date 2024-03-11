package ru.netology.boldarev.exception;

public class CustomerOperationOutOfBoundException extends OperationRuntimeException {
    public static final String MESSAGE = "Exception while trying to save operation %s for customer %s";
    private final int customerId;
    private final int operationId;

    public CustomerOperationOutOfBoundException(int customerId, int operationId) {
        super();
        this.customerId = customerId;
        this.operationId = operationId;
    }

    @Override
    public String getMessage(){
        return MESSAGE.formatted(operationId, customerId);
    }
}
