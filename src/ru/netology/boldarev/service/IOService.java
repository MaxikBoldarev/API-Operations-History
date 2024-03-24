package ru.netology.boldarev.service;

import ru.netology.boldarev.model.Customer;
import ru.netology.boldarev.model.Operation;
import ru.netology.boldarev.serializable.OperationData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class IOService {
    private static final String PATH = "D:\\save.ser";
    Path serializable = Paths.get(PATH);
    public static final StorageService<Customer> customerStorageService = new StorageService<>();
    public static final StorageService<Operation> operationStorageService = new StorageService<>();
    public static final StatementService statementService = new StatementService();

    public static OperationService operationService = new OperationService();
    CustomerService customerService = new CustomerService();

    Scanner scanner = new Scanner(System.in);

    public void addCustomer() {
        System.out.println("Введите Имя получателя: ");
        String firstName = scanner.next();
        System.out.println("Введите возраст получателя: ");
        int age = scanner.nextInt();
        int countId = customerService.countId();
        Customer customer = new Customer(countId, firstName, age);
        customerService.add(customer);
    }

    public void addOperation(AsyncInputOperationService asyncInputOperationService) {
        System.out.println("Введите сумму: ");
        double amount = scanner.nextDouble();
        System.out.println("Введите дату: ");
        int date = scanner.nextInt();
        System.out.println("Введите имя получателя");
        String name = scanner.next();
        int customerId = customerService.findCustomerRepo(name);
        if (customerId == 404) {
            System.out.println("Повторите попытку.");
        } else {
            int countId = operationService.countId();
            Operation operation = new Operation(countId, amount, date);
            statementService.addId(customerId, operation);
            System.out.println(asyncInputOperationService.offerOperation(operation));
        }
    }

    public void printOperationByCustomer() {
        System.out.println("Введите имя получателя: ");
        String nameCustomer = scanner.next();
        int customerId = customerService.findCustomerRepo(nameCustomer);
        List<Operation> operationList = operationService.getOperationsCustomer(customerId);
        System.out.println(operationList);
    }

    public void printAllOperation() {
        System.out.println(operationService.getAll());
    }

    public void printAllCustomer() {
        System.out.println(customerService.getAll());
    }

    public void serializableFiles() {
        try (FileOutputStream outputStream = new FileOutputStream(PATH)) {
            OperationData operationData = new OperationData(operationService.getAll(), customerService.getAll(), statementService.getAllStatement());
            System.out.println(operationData);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(operationData);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void existAndSerializable() {
        if (Files.exists(serializable)) {
            try (FileInputStream fileInputStream = new FileInputStream(String.valueOf(serializable));
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                OperationData operationData = (OperationData) objectInputStream.readObject();

                customerStorageService.setList(operationData.getCustomers());

                operationStorageService.setList(operationData.getOperations());

                statementService.setStatementRepository(operationData.getStatement());

                System.out.println(operationData);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка восстановления данных");
            }
        } else
            System.out.printf("'%s' не сущетсвует%n", serializable);
    }
}



