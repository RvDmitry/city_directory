package name.dmitryrazumov.directory.store;

import name.dmitryrazumov.directory.model.City;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileDirectoryTest {

    private final City one = new City("Майкоп", "Адыгея",
            "Южный", 144246, 1857);
    private final City two = new City("Абаза", "Хакасия",
            "Сибирский", 17111, 1867);
    private final City three = new City("Омск", "Омская область",
            "Сибирский", 1139897, 1716);
    private final City four = new City("Адыгейск", "Адыгея",
            "Южный", 12248, 1973);

    private Store directory;

    @Before
    public void init() {
        directory = new FileDirectory();
        directory.add(one);
        directory.add(two);
        directory.add(three);
        directory.add(four);
    }

    @Test
    public void whenFindAll() {
        List<City> cities = directory.findAll();
        assertThat(cities, is(Arrays.asList(one, two, three, four)));
    }

    @Test
    public void whenSortByName() {
        List<City> cities = directory.sortByName();
        assertThat(cities, is(Arrays.asList(two, four, one, three)));
    }

    @Test
    public void whenSortByDistrictAndName() {
        List<City> cities = directory.sortByDistrictAndName();
        assertThat(cities, is(Arrays.asList(two, three, four, one)));
    }

    @Test
    public void whenFindMax() {
        List<City> max = directory.findMax();
        assertThat(max.get(0), is(three));
    }

    @Test
    public void whenGroupByRegions() {
        Map<String, Long> regions = new TreeMap<>(directory.groupByRegions());
        String expect = new StringJoiner(", ", "{", "}")
                .add("Адыгея=2")
                .add("Омская область=1")
                .add("Хакасия=1")
                .toString();
        assertThat(regions.toString(), is(expect));
    }
}