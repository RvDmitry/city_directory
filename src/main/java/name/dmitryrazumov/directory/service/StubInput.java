package name.dmitryrazumov.directory.service;

/**
 * Class StubInput
 * Класс имитирует взаимодействие пользователя с объектом Scanner.
 * @author Dmitry Razumov
 * @version 1
 */
public class StubInput implements Input {
    /**
     * Массив ответов пользователя.
     */
    private String[] answers;

    /**
     * Счетчик элементов массива.
     */
    private int position = 0;

    /**
     * Конструктор инициализирует массив ответов пользователя.
     * @param answers Массив ответов пользователя
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод имитирует ответы пользователя,
     * возвращая заранее переданный массив ответов поэлементно при вызове метода.
     * @param message Сообщение для пользователя.
     * @return Элементы массива ответов.
     */
    @Override
    public String askStr(String message) {
        return answers[position++];
    }

    /**
     * Метод имитирует ответы пользователя,
     * возвращая заранее переданный массив ответов поэлементно при вызове метода.
     * @param message Сообщение для пользователя.
     * @return Элементы массива ответов.
     */
    @Override
    public int askInt(String message) {
        return Integer.parseInt(askStr(message));
    }

    /**
     * Метод имитирует ответы пользователя,
     * возвращая заранее переданный массив ответов поэлементно при вызове метода.
     * @param message Сообщение для пользователя.
     * @param max Максимальное число, которое может ввести пользователь.
     * @return Элементы массива ответов.
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
