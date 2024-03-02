package ru.netology.boldarev.model;

public class Customer {
    private String firstName;
    private String secondName;
    private int age;


    private int id;

    public Customer(int id, Customer customer) {
        this.id = id;
        this.firstName = customer.firstName;
        this.secondName = customer.secondName;
        this.age = customer.age;
    }

    public Customer(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        if(age < 18 || age > 80){
            this.age = 18;
        } else{
            this.age = age;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
