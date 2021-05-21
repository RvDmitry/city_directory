package name.dmitryrazumov.directory.service;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"one", "1"})
        );
        input.askInt("");
        assertThat(mem.toString(), is(String.format("Вы ввели не число.  Повторите ввод.%n")));
        System.setOut(out);
    }

    @Test
    public void whenMaxErrorInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"4", "1"})
        );
        input.askInt("", 2);
        System.setOut(out);
        assertThat(mem.toString(), is(String.format("Неверный пункт меню. Повторите ввод.%n")));
    }
}