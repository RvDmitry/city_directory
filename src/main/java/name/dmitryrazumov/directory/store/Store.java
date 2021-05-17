package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;

import java.util.List;

/**
 * Interface Store
 * Интерфейс определяет методы взаимодействия со справочником городов.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {
    /**
     * Метод загружает список городов из файла.
     * @param name Имя файла.
     */
    void load(String name);

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
}
