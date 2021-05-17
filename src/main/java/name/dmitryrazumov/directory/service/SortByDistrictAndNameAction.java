package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.Store;

import java.util.List;

/**
 * Class SortByDistrictAndNameAction
 * Класс реализует элемент меню, который выводит отсортированный
 * по федеральным округам и наименованию список городов.
 * @author Dmitry Razumov
 * @version 1
 */
public class SortByDistrictAndNameAction implements UserAction {
    @Override
    public String name() {
        return "Вывести и отсортировать города по федеральным округам и наименованию.";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        List<City> cities = directory.sortByDistrictAndName();
        for (var city : cities) {
            System.out.println(city);
        }
        return true;
    }
}
