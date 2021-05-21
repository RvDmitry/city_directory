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

    @Override
    public String askStr(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String message) {
        return Integer.parseInt(askStr(message));
    }

    @Override
    public int askInt(String message, int max) {
        int select = askInt(message);
        if (select < 1 || select > max) {
            throw new IllegalStateException("Неверный пункт меню. Повторите ввод.");
        }
        return select;
    }
}
