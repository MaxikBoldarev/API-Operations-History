package ru.netology.boldarev.service;

import ru.netology.boldarev.exception.OperationRuntimeException;
import ru.netology.boldarev.model.Customer;


import java.util.List;

import static ru.netology.boldarev.service.IOService.customerStorageService;


public class CustomerService {
    private int customerId = 0;

    public int countId() {
        if (customerId == 0) {
            List<Customer> listCustomer = customerStorageService.getAll();
            for (Customer cust : listCustomer) {
                if (cust != null) {
                    customerId++;
                }
            }
            return customerId;
        }
        return 0;
    }

    public void add(Customer customer) throws OperationRuntimeException {
        try {
            customerStorageService.add(customer);
        } catch (OperationRuntimeException e) {
            System.out.println("Ошибка добавления получателя");
        }
    }

    public int findCustomerRepo(String name) {
        String firstNameFind = name.toLowerCase().trim();
        List<Customer> listCustomer = customerStorageService.getAll();
        for (Customer customer : listCustomer) {
            String firstName = customer.getFirstName()
                    .toLowerCase()
                    .trim();
            if (firstNameFind.equals(firstName)) {
                return customer.getId();
            }
        }
        System.out.println("Получаетель не был найден.");
        return 404;
    }

    public List<Customer> getAll() {
        return customerStorageService.getAll();
    }
}