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

public class FindAllActionTest {

    @Test
    public void whenFindAll() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store directory = new FileDirectory();
        City city = new City("Алдан", "Якутия",
                "Дальневосточный", 21277, 1924);
        directory.add(city);
        FindAllAction action = new FindAllAction();
        action.execute(new StubInput(new String[] {}), directory);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(city.toString())
                .toString();
        System.setOut(out);
        assertThat(mem.toString(), is(expect));
    }
}