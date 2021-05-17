package name.dmitryrazumov.directory.service;

import java.util.Scanner;

/**
 * Class ConsoleInput
 * Класс считывает данные введенные пользователем в консоли.
 * @author Dmitry Razumov
 * @version 1
 */
public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод задает пользователю вопрос и возвращает введенный пользователем ответ в виде строки.
     * @param message Сообщение для пользователя.
     * @return Строка введенная пользователем.
     */
    @Override
    public String askStr(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Метод задает пользователю вопрос и возвращает введенный пользователем ответ в виде числа.
     * @param message Сообщение для пользователя.
     * @return Число введенное пользователем.
     */
    @Override
    public int askInt(String message) {
        return Integer.parseInt(askStr(message));
    }

    /**
     * Метод запрашивает от пользователя ввод данных от 0 до max.
     * @param message Сообщение для пользователя.
     * @param max Максимальное число, которое может ввести пользователь.
     * @return Число введенное пользователем.
     */
    @Override
    public int askInt(String message, int max) {
        int select = askInt(message);
        if (select < 0 || select >= max) {
            throw new IllegalStateException("Неверный пункт меню. Повторите ввод.");
        }
        return select;
    }
}
