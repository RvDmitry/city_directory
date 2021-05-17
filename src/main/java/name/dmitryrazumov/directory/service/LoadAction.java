package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.store.Store;

/**
 * Class LoadAction
 * Класс описывает элемент меню для загрузки справочника городов.
 * @author Dmitry Razumov
 * @version 1
 */
public class LoadAction implements UserAction {

    @Override
    public String name() {
        return "Загрузить данные из справочника";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        String name =  input.askStr("Введите имя файла: ");
        directory.load(name);
        return true;
    }
}
