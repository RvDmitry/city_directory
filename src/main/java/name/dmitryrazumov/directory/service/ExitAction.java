package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.store.Store;

/**
 * Class ExitAction
 * Класс отвечает за выход из приложения.
 * @author Dmitry Razumov
 * @version 1
 */
public class ExitAction implements UserAction {

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        return false;
    }
}
