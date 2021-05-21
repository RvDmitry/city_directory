package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public void load(String name) {
        try (BufferedReader in = new BufferedReader(new FileReader(name))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] str = s.split(";");
                if (str.length == 6) {
                    cities.add(
                            new City(str[1], str[2], str[3],
                                    Integer.parseInt(str[4]), Integer.parseInt(str[5]))
                    );
                }
            }
            System.out.println("Файл загружен успешно.");
        } catch (NumberFormatException e) {
            System.out.println("В файле справочника имеются ошибки.");
        } catch (Exception e) {
            System.out.println("Файл не найден.");
        }
    }

    @Override
    public City add(City city) {
        cities.add(city);
        return city;
    }

    @Override
    public List<City> findAll() {
        return cities;
    }

    @Override
    public List<City> sortByName() {
        Comparator<City> comp = Comparator.comparing(city -> city.getName().toLowerCase());
        return sortCityDirectory(comp);
    }

    @Override
    public List<City> sortByDistrictAndName() {
        Comparator<City> comp = Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName);
        return sortCityDirectory(comp);
    }

    @Override
    public List<City> findMax() {
        List<City> list = new ArrayList<>();
        Optional<City> max = cities.stream().max(Comparator.comparing(City::getPopulation));
        if (max.isPresent()) {
            list = cities.stream().filter(city -> city.getPopulation() == max.get().getPopulation())
                    .collect(Collectors.toList());
        }
        return list;
    }

    @Override
    public Map<String, Long> groupByRegions() {
        return cities.stream().collect(
                Collectors.groupingBy(City::getRegion, Collectors.counting())
        );
    }

    private List<City> sortCityDirectory(Comparator<City> comparator) {
        List<City> sorted = new ArrayList<>(cities);
        sorted.sort(comparator);
        return sorted;
    }
}
