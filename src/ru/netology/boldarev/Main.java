package ru.netology.boldarev;

import ru.netology.boldarev.model.Customer;
import ru.netology.boldarev.model.Operation;
import ru.netology.boldarev.repository.CustomerRepository;
import ru.netology.boldarev.repository.OperationRepository;
import ru.netology.boldarev.serializable.OperationData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    static final String PATH = "D:\\save.ser" ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomerRepository customerRepository = new CustomerRepository();
        OperationRepository operationRepository = new OperationRepository();

        OperationData operationData;

        Customer customer;
        Operation operation;

        //Проверка на наличие файла и дессериализация
        Path serializable = Paths.get(PATH);
        existAndSerializable(serializable);


        boolean b = true;

        while (b) {

            System.out.println("""
                    Добрый день, какую из нижеперечисленных операций желаете выполнить?
                    1. Добавить получателя
                    2. Выполнить перевод
                    3. Вывести список операций по получателю
                    4. Вывести полный список получателей
                    5. Вывести полный список операций
                    6. Сохранить операции в файл
                    7. Заверщение работы
                    """);

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Введите Имя получателя: ");
                    String firstName = scanner.next();
                    System.out.println("Введите Фамилию получателя: ");
                    String secondName = scanner.next();
                    System.out.println("Введите возраст получателя: ");
                    int age = scanner.nextInt();
                    customer = new Customer(firstName, secondName, age);
                    customerRepository.addCustomer(customer);
                    break;
                case 2:
                    System.out.println("Введите сумму: ");
                    double amount = scanner.nextDouble();
                    System.out.println("Введите дату: ");
                    int date = scanner.nextInt();
                    System.out.println("Введите имя получателя");
                    String name = scanner.next();
                    int customerId = customerRepository.findCustomerRepo(name);
                    if (customerId == 404) {
                        System.out.println("Повторите попытку.");
                    } else {
                        operation = new Operation(amount, date);
                        operationRepository.addOperation(operation, customerId);
                    }
                    break;
                case 3:
                    System.out.println("Введите имя получателя: ");
                    String nameCustomer = scanner.next();
                    int nameId = customerRepository.findCustomerRepo(nameCustomer);
                    Operation[] operationsCustomer = operationRepository.getOperationsCustomer(nameId);
                    operationRepository.printOperation(operationsCustomer);
                    break;
                case 4:
                    System.out.println("Полный список получателей: ");
                    customerRepository.print();
                    break;
                case 5:
                    System.out.println("Полный список операций ");
                    operationRepository.print();
                    break;
                case 6:
                    try (FileOutputStream outputStream = new FileOutputStream(PATH)) {
                        operationData = new OperationData(operationRepository.getOperations(), customerRepository.getCustomers(), operationRepository.getStatement());
                        System.out.println(operationData);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        objectOutputStream.writeObject(operationData);
                        objectOutputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 7:
                    System.out.println("Это было супер!");
                    b = false;
                    break;
                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }
    }

    private static void existAndSerializable(Path path) {
        if (Files.exists(path)) {
            try (FileInputStream fileInputStream = new FileInputStream(String.valueOf(path));
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                OperationData operationData = (OperationData) objectInputStream.readObject();

                CustomerRepository customerRepository = new CustomerRepository();
                customerRepository.setCustomers(operationData.getCustomers());


                OperationRepository operationRepository = new OperationRepository();
                operationRepository.setStatement(operationData.getStatement());
                operationRepository.setOperation(operationData.getOperations());

                System.out.println(operationData);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка восстановления данных");
            }
        } else
            System.out.printf("'%s' не сущетсвует%n", path);
    }
}

