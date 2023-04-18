package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private String expectedName;
    private float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Check bun with name {0} and price {1}")
    public static Object[][] getData() {
        return new Object[][] {
                { "", 1.0f },
                { null, 1.0f },
                { "Very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong name", 1.0f },
                { "Name!@#$%^&*()_+{}:\"|<>?`-=[]\\;',./", 1.0f },
                { "Test Bun", -1.0f},
                { "Test Bun", 0.0f},
                { "Test Bun", Float.MAX_VALUE},
                { "Test Bun", Float.MIN_VALUE},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testCreateBunAndCheckName() {
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testCreateBunAndCheckPrice() {
        assertEquals(expectedPrice, bun.getPrice(), 0.0f);
    }
}
