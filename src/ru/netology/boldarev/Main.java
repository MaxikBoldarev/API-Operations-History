package ru.netology.boldarev;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        int count = 0;

        String name;
        int sum;
        

        System.out.println("Hello, Max!");

        while (count < 5) {
            Date currentDate = new Date();

            System.out.println("Введите имя получателя: ");
            name = scanner.next();

            System.out.println("Введите сумму: ");
            sum = scanner.nextInt();

            stringBuilder.append("Сумма: ")
                    .append(sum)
                    .append(", отправлена получателю: ")
                    .append(name).append(" Дата отправки: ")
                    .append(currentDate).append("\n");

            count++;
        }

        String result = stringBuilder.toString();

        System.out.println(result);
    }
}
