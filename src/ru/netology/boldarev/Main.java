package ru.netology.boldarev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 0;

        String name;
        double sum;
        int date;

        double[] sumRepository = new double[5];
        String[] nameRepository = new String[5];
        int[] currentDateRepository = new int[5];

        System.out.println("Hello, Max!");

        while (count < 5) {

            System.out.println("Введите имя получателя: ");
            name = scanner.next();

            System.out.println("Введите сумму: ");
            sum = scanner.nextInt();

            System.out.println("Введите Дату: ");
            date = scanner.nextInt();

            sumRepository[count] = sum;
            nameRepository[count] = name;
            currentDateRepository[count] = date;

            count++;
        }

        printTransaction(currentDateRepository, nameRepository, sumRepository);

    }

    public static void printTransaction(int[] currentDateRepository, String[] nameRepository, double[] sumRepository) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите диапазон дат для поиска");

        int dateFirst = scanner.nextInt();
        int dateSecond = scanner.nextInt();

        while (dateFirst < dateSecond) {
            for (int i = 0; i < currentDateRepository.length; i++) {
                if (currentDateRepository[i] == dateFirst) {
                    System.out.println("Имя получателя " + nameRepository[i] + ", " +
                            "Сумма " + sumRepository[i] + ", " +
                            "Дата " + currentDateRepository[i] + " Февраля.");
                }
            }
            dateFirst++;
        }
    }
}

