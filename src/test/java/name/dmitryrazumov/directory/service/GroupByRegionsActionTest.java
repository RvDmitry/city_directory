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

public class GroupByRegionsActionTest {

    @Test
    public void whenGroupByRegions() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store directory = new FileDirectory();
        City first = new City("Агрыз", "Татарстан",
                "Приволжский", 19299, 1646);
        City second = new City("Казань", "Татарстан",
                "Приволжский", 1257341, 1005);
        City third = new City("Абдулино", "Оренбургская область",
                "Приволжский", 2066, 1795);
        directory.add(first);
        directory.add(second);
        directory.add(third);
        GroupByRegionsAction action = new GroupByRegionsAction();
        action.execute(new StubInput(new String[] {}), directory);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Оренбургская область - 1")
                .add("Татарстан - 2")
                .toString();
        System.setOut(out);
        assertThat(mem.toString(), is(expect));
    }
}