package name.dmitryrazumov.directory.service;

/**
 * Class ValidateInput
 * Класс выполняет валидацию введенных пользователем значений.
 * @author Dmitry Razumov
 * @version 1
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод, вызывает метод класса источника данных для выполнения требуемых действий.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Ответ на заданный вопрос
     */
    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    /**
     * Метод осуществляет валидацию введенного пользователем числа.
     * @param question Вопрос на который нужно ответить пользователю
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели не число.  Повторите ввод.");
            }
        } while (invalid);
        return value;
    }

    /**
     * Метод осуществляет валидацию введенного пользователем числа.
     * @param question Вопрос на который нужно ответить пользователю
     * @param max Максимальное число, которое может ввести пользователь
     * @return Число введенное пользователем
     */
    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели не число. Повторите ввод.");
            }
        } while (invalid);
        return value;
    }
}
