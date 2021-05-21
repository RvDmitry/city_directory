package name.dmitryrazumov.directory;

import name.dmitryrazumov.directory.service.StubAction;
import name.dmitryrazumov.directory.service.StubInput;
import name.dmitryrazumov.directory.store.FileDirectory;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MainTest {

    @Test
    public void whenPrintMenu() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        StubInput input = new StubInput(
                new String[] {"1"}
        );
        StubAction action = new StubAction();
        new Main().init(input, new FileDirectory(), Arrays.asList(action));
        String expect = new StringJoiner(
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator())
                .add("Menu.")
                .add("1. Stub action")
                .toString();
        System.setOut(out);
        assertThat(mem.toString(), is(expect));
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"1"}
        );
        StubAction action = new StubAction();
        new Main().init(input, new FileDirectory(), Arrays.asList(action));
        assertThat(action.isCall(), is(true));
    }
}