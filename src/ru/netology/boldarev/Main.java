package ru.netology.boldarev;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name;
        int sum;
        Date currentDate = new Date();

        System.out.println("Hello, Max!");

        System.out.println("Введите имя получателя: ");
        name = scanner.nextLine();

        System.out.println("Введите сумму: ");
        sum = scanner.nextInt();

        System.out.println("Сумма: " + sum + ", отправлена получателю: " + name + " Дата отправки: " + currentDate);
    }
}
