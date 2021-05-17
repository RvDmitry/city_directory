package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.Store;

import java.util.List;

/**
 * Class SortByNameAction
 * Класс реализует элемент меню, который выводит отсортированный по наименованию список городов.
 * @author Dmitry Razumov
 * @version 1
 */
public class SortByNameAction implements UserAction {

    @Override
    public String name() {
        return "Вывести и отсортировать города по наименованию.";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        List<City> cities = directory.sortByName();
        for (var city : cities) {
            System.out.println(city);
        }
        return true;
    }
}
