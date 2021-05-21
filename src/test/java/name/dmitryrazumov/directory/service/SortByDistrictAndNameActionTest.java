package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.FileDirectory;
import name.dmitryrazumov.directory.store.Store;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortByDistrictAndNameActionTest {

    @Test
    public void whenSortByDistrictAndName() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store directory = new FileDirectory();
        City first = new City("Агрыз", "Татарстан",
                "Приволжский", 19299, 1646);
        City second = new City("Амурск", "Хабаровский край",
                "Дальневосточный", 42977, 1958);
        City third = new City("Абдулино", "Оренбургская область",
                "Приволжский", 2066, 1795);
        directory.add(first);
        directory.add(second);
        directory.add(third);
        SortByDistrictAndNameAction action = new SortByDistrictAndNameAction();
        action.execute(new StubInput(new String[] {}), directory);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(second.toString())
                .add(third.toString())
                .add(first.toString())
                .toString();
        System.setOut(out);
        assertThat(mem.toString(), is(expect));
    }
}