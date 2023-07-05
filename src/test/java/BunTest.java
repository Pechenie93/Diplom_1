import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final Bun bun;

    public BunTest(Bun bun) {
        this.bun = bun;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {new Bun("black bun", 100)},
                {new Bun("white bun", 200)},
                {new Bun("white bun", 10)},
        });
    }

    @Test
    public void getNameTest() {
        String expectedName = bun.getName();
        assertEquals(expectedName, bun.getName());
    }
// *
    @Test
    public void getPriseTest() {
        int expectedPrice = (int) bun.getPrice();
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }
}