package name.dmitryrazumov.directory;

import name.dmitryrazumov.directory.service.*;
import name.dmitryrazumov.directory.store.FileDirectory;
import name.dmitryrazumov.directory.store.Store;

import java.util.Arrays;
import java.util.List;

/**
 * Class Main
 * Класс реализует меню справочника.
 * @author Dmitry Razumov
 * @version 1
 */
public class Main {
    /**
     * Метод обрабатывает действия пользователя при работе с меню.
     * @param input Объект для считывания ответов пользователя
     * @param directory Объект для работы со справочником городов.
     * @param actions Список действий пользователя.
     */
    public void init(Input input, Store directory, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, directory);
        }
    }

    /**
     * Метод отображает меню приложения на экране.
     * @param actions Список меню.
     */
    private void showMenu(List<UserAction> actions) {
        System.out.println(System.lineSeparator() + "Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     * Главный метод программы.
     * Создает список действий для пользователя.
     * Запускает выполнение приложения.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Store directory = new FileDirectory();
        List<UserAction> actions = Arrays.asList(
                new LoadAction(),
                new FindAllAction(),
                new SortByNameAction(),
                new SortByDistrictAndNameAction(),
                new ExitAction()
        );
        new Main().init(validate, directory, actions);
    }
}
