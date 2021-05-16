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
     * Метод возвращает список всех городов из справочника.
     * @return Список городов.
     */
    List<City> findAll();
}
