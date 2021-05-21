package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;

import java.util.List;
import java.util.Map;

/**
 * Interface Store
 * Интерфейс определяет методы взаимодействия со справочником городов.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {
    /**
     * Метод загружает список городов из хранилища.
     * @param name Имя файла.
     */
    void load(String name);

    /**
     * Метод добавляет город в справочник.
     * @param city Город.
     * @return Добавленный город.
     */
    City add(City city);

    /**
     * Метод возвращает список всех городов из справочника.
     * @return Список городов.
     */
    List<City> findAll();

    /**
     * Метод возвращает список городов отсортированных
     * по наименованию.
     * @return Список городов.
     */
    List<City> sortByName();

    /**
     * Метод возвращает список городов отсортированных
     * по федеральным округам и наименованию.
     * @return Список городов.
     */
    List<City> sortByDistrictAndName();

    /**
     * Метод ищет города с наибольшим количеством жителей.
     * @return Список содержащий города с наибольшим количеством жителей и индекс города в списке.
     */
    List<City> findMax();

    /**
     * Метод возвращает карту,
     * в которой содержится наименование региона
     * и количество городов в нем.
     * @return Карта регионов.
     */
    Map<String, Long> groupByRegions();
}
