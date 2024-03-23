package ru.netology.boldarev.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String firstName;
    private int age;
    private int id;


    public Customer(int id, String firstName, int age) {
        this.id = id;
        this.firstName = firstName;
        if (age < 18 || age > 80) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public String getFirstName() {
        return firstName;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
