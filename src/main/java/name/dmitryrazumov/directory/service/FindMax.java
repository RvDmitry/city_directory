package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.Store;

import java.util.List;

/**
 * Class FindMax
 * Класс реализует элемент меню,
 * который ищет город с наибольшим количеством жителей.
 * @author Dmitry Razumov
 * @version 1
 */
public class FindMax implements UserAction {

    @Override
    public String name() {
        return "Вывести город с наибольшим количеством жителей.";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        List<City> cities = directory.findMax();
        for (var city : cities) {
            System.out.printf("%s = %d %n", city.getName(), city.getPopulation());
        }
        return true;
    }
}
