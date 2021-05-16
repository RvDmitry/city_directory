package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.store.Store;

/**
 * Class LoadAction
 * Класс загружает список городов из справочника.
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
        return true;
    }
}
