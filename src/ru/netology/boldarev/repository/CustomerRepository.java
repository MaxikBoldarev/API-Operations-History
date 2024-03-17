package ru.netology.boldarev.repository;

import ru.netology.boldarev.exception.OperationRuntimeException;
import ru.netology.boldarev.service.ConsolePrintable;
import ru.netology.boldarev.model.Customer;

public class CustomerRepository implements ConsolePrintable {

    private int customerId = 0;

    private static Customer[] customers = new Customer[100];


    public void addCustomer(Customer customer) throws OperationRuntimeException {
        if (customerId == 0) {
            for (Customer customer1 : customers) {
                if (customer1 != null) {
                    customerId++;
                }
            }
        }
        if (customerId == 99) {
            System.out.println("Репозиторий заполнен");
        } else {
            try {
                Customer customer1 = new Customer(customerId, customer);
                customers[customerId] = customer1;
                customerId++;
            } catch (OperationRuntimeException e) {
                System.out.println("Ошибка добавления получателя");
            }
        }
    }

    public int findCustomerRepo(String name) {
        String firstNameFind = name.toLowerCase().trim();
        for (Customer customer : customers) {
            String firstName = customer.getFirstName();
            String firstNameCustomer = firstName.toLowerCase().trim();
            if (firstNameFind.equals(firstNameCustomer)) {
                return customer.getId();
            }
        }
        System.out.println("Получаетель не был найден.");
        return 404;
    }

    @Override
    public void print() {
        for (Customer customer : customers) {
            if (customer == null) {
                break;
            } else {
                System.out.println(customer);
            }
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customer) {
        CustomerRepository.customers = customer;
    }
}
