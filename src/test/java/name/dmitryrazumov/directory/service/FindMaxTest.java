package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.model.City;
import name.dmitryrazumov.directory.store.FileDirectory;
import name.dmitryrazumov.directory.store.Store;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindMaxTest {

    @Test
    public void whenFindMax() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store directory = new FileDirectory();
        City first = new City("Майкоп", "Адыгея",
                "Южный", 144246, 1857);
        City second = new City("Алдан", "Якутия",
                "Дальневосточный", 21277, 1924);
        directory.add(first);
        directory.add(second);
        FindMax action = new FindMax();
        action.execute(new StubInput(new String[] {}), directory);
        System.setOut(out);
        assertThat(mem.toString(), is(
                String.format("%s = %d", first.getName(), first.getPopulation())
                )
        );
    }
}