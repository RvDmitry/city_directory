package name.dmitryrazumov.directory.service;

/**
 * Interface Input
 * Интерфейс определяет работу класса по получению данных от пользователя.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Input {
    /**
     * Метод возвращает введенную строку от пользователя.
     * @param message Сообщение для пользователя.
     * @return Строка введенная пользователем.
     */
    String askStr(String message);

    /**
     * Метод возвращает введенное число от пользователя.
     * @param message Сообщение для пользователя.
     * @return Число введенное пользователем.
     */
    int askInt(String message);

    /**
     * Метод запрашивает от пользователя ввод данных от 1 до max.
     * @param message Сообщение для пользователя.
     * @param max Максимальное число, которое может ввести пользователь.
     * @return Число введенное пользователем.
     */
    int askInt(String message, int max);
}
