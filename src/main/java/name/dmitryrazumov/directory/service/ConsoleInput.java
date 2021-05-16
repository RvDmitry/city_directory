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
     * @param question Вопрос на который нужно ответить пользователю
     * @return Строка введенная пользователем
     */
    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод задает пользователю вопрос и возвращает введенный пользователем ответ в виде числа.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    /**
     * Метод запрашивает от пользователя ввод данных от 0 до max.
     * @param question Вопрос на который нужно ответить пользователю
     * @param max Максимальное число, которое может ввести пользователь
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException("Неверный пункт меню. Повторите ввод.");
        }
        return select;
    }
}
