package ru.netology.boldarev;

import ru.netology.boldarev.service.IOService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IOService ioService = new IOService();
        Scanner scanner = new Scanner(System.in);

        //Проверка на наличие файла и дессериализация
        ioService.existAndSerializable();

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
                    ioService.addCustomer();
                    break;
                case 2:
                    ioService.addOperation();
                    break;
                case 3:
                    ioService.printOperationByCustomer();
                    break;
                case 4:
                    System.out.println("Полный список получателей: ");
                    ioService.printAllCustomer();
                    break;
                case 5:
                    System.out.println("Полный список операций ");
                    ioService.printAllOperation();
                    break;
                case 6:
                    ioService.serializableFiles();
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
}

