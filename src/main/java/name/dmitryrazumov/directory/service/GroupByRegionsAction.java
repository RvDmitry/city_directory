package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.store.Store;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class GroupByRegionsAction
 * Класс реализует элемент меню,
 * который группирует регионы по количеству городов в них.
 * @author Dmitry Razumov
 * @version 1
 */
public class GroupByRegionsAction implements UserAction {

    @Override
    public String name() {
        return "Вывести регионы и количество городов в них.";
    }

    @Override
    public boolean execute(Input input, Store directory) {
        Map<String, Long> regionsGroup = new TreeMap(directory.groupByRegions());
        for (var entry : regionsGroup.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return true;
    }
}
