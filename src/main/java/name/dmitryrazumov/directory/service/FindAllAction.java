package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.Store;

import java.util.List;

/**
 * Class FindAllAction
 * Класс выводит список городов из справочника.
 * @author Dmitry Razumov
 * @version 1
 */
public class FindAllAction implements UserAction {

    @Override
    public String name() {
        return "Вывести все города из справочника.";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        List<City> cities = directory.findAll();
        for (var city : cities) {
            System.out.println(city);
        }
        return true;
    }
}
