package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Class FileDirectory
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class FileDirectory implements Store {
    /**
     * Список для хранения городов.
     */
    private final List<City> cities = new ArrayList<>();

    @Override
    public List<City> findAll() {
        return cities;
    }
}
