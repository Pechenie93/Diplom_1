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
                {new Bun("black bun", 100)},             // Valid data - black bun with price 100
                {new Bun("white bun", 200)},             // Valid data - white bun with price 200
                {new Bun("white bun", 10)},              // Valid data - white bun with price 10
                {new Bun("white-black bun", 1)},         // Valid data - white-black bun with price 1
                {new Bun("white bun", 0)},               // Valid data - white bun with price 0
                {new Bun(null, 100)},                     // Invalid data - null name with price 100
                {new Bun("black bun", -50)},              // Invalid data - black bun with negative price
                {new Bun("", 200)},                       // Invalid data - empty name with price 200
                {new Bun("white bun", 1000000)},          // Invalid data - white bun with a very high price
        });
    }

    @Test
    public void getNameTest() {
        String expectedName = bun.getName();
        assertEquals(expectedName, bun.getName());
    }
// *
    @Test
    public void getPriceTest() {
        int expectedPrice = (int) bun.getPrice();
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }
}