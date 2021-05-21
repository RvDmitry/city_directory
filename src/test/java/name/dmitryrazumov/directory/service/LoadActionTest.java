package name.dmitryrazumov.directory.service;

import name.dmitryrazumov.directory.store.FileDirectory;
import name.dmitryrazumov.directory.store.Store;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoadActionTest {

    @Test
    public void whenLoadFail() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Store directory = new FileDirectory();
        LoadAction action = new LoadAction();
        action.execute(new StubInput(new String[] {"1"}), directory);
        System.setOut(out);
        assertThat(mem.toString(), is(String.format("Файл не найден.%n")));
    }
}