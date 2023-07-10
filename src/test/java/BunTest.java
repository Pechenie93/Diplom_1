import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100f},             // Valid data - black bun with price 100
                {"white bun", 200f},             // Valid data - white bun with price 200
                {"white bun", 10f},              // Valid data - white bun with price 10
                {"white-black bun", 1f},         // Valid data - white-black bun with price 1
                {"white bun", 0f},               // Valid data - white bun with price 0
                {null, 100f},                     // Invalid data - null name with price 100
                {"black bun", -50f},              // Invalid data - black bun with negative price
                {"", 200f},                       // Invalid data - empty name with price 200
                {"white bun", 1000000f},          // Invalid data - white bun with a very high price
        });
    }

    @Test
    public void returnActualNameAndPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0);
    }
}