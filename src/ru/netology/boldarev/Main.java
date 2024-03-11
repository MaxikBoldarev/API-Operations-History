package ru.netology.boldarev;


import ru.netology.boldarev.exception.OperationException;
import ru.netology.boldarev.model.Customer;
import ru.netology.boldarev.model.Operation;
import ru.netology.boldarev.repository.CustomerRepository;
import ru.netology.boldarev.repository.OperationRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OperationException {

        CustomerRepository customerRepository = new CustomerRepository();
        OperationRepository operationRepository = new OperationRepository();
        Customer customer;
        Operation operation;


        Scanner scanner = new Scanner(System.in);

        boolean b = true;

        while (b) {

            System.out.println("""
                    Добрый день, какую из нижеперечисленных операций желаете выполнить?
                    1. Добавить получателя
                    2. Выполнить перевод
                    3. Вывести список операций по получателю
                    4. Вывести полный список получателей
                    5. Вывести полный список операций
                    6. Заверщение работы
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
                    Operation[] operationsCustomer = OperationRepository.getOperations(nameId);
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
                    System.out.println("Это было супер!");
                    b = false;
                    break;
                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }
    }
}

