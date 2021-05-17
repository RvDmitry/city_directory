package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class FileDirectory
 * Класс загружает данные из справочника.
 * @author Dmitry Razumov
 * @version 1
 */
public class FileDirectory implements Store {
    /**
     * Список для хранения городов.
     */
    private final List<City> cities = new ArrayList<>();

    /**
     * Метод загружает список городов из файла.
     * @param name Имя файла.
     */
    @Override
    public void load(String name) {
        try (BufferedReader in = new BufferedReader(new FileReader(name))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] str = s.split(";");
                if (str.length == 6) {
                    cities.add(new City(str[1], str[2], str[3], str[4], str[5]));
                }
            }
            System.out.println("Файл загружен успешно.");
        } catch (Exception e) {
            System.out.println("Файл не найден.");
        }
    }

    /**
     * Метод возвращает список городов.
     * @return Список городов.
     */
    @Override
    public List<City> findAll() {
        return cities;
    }

    /**
     * Метод сортирует список городов по наименованию.
     * @return Список городов.
     */
    @Override
    public List<City> sortByName() {
        Comparator<City> comp = Comparator.comparing(city -> city.getName().toLowerCase());
        return sortCityDirectory(comp);
    }

    /**
     * Метод сортирует список городов по федеральным округам и наименованию.
     * @return Список городов.
     */
    @Override
    public List<City> sortByDistrictAndName() {
        Comparator<City> comp = Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName);
        return sortCityDirectory(comp);
    }

    /**
     * Метод выполняет сортировку списка городов в соответствии с заданным условием.
     * @param comparator Компаратор определяет сортировку.
     * @return Отсортированный список городов.
     */
    private List<City> sortCityDirectory(Comparator<City> comparator) {
        List<City> sorted = new ArrayList<>(cities);
        sorted.sort(comparator);
        return sorted;
    }
}
