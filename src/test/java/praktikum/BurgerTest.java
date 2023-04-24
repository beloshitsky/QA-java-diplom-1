package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Ingredient ingredient;

    @Mock
    private Bun bun;

    public BurgerTest(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {new Ingredient(IngredientType.SAUCE, "test sauce", 1)},
                {new Ingredient(IngredientType.FILLING, "test filling", 1.1f)},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("test bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
    }

    @Test
    public void testAddIngredient() {
        assertNotNull(burger.ingredients);
    }

    @Test
    public void testGetReceipt() {
        assertNotNull(burger.getReceipt());
    }

    @Test
    public void testGetReceiptShowBunAndIngredients() {
        String actualBun = bun.getName();
        String actualIngredient = burger.ingredients.get(0).getName();

        assertTrue(burger.getReceipt().contains(actualBun));
        assertTrue(burger.getReceipt().contains(actualIngredient));
    }

    @Test
    public void testGetPriceFromReceipt() {
        assertEquals(201f, burger.getPrice(), 0.5);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        boolean isEmptyIngredients = burger.ingredients.isEmpty();

        assertTrue(isEmptyIngredients);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "new sauce", 0));
        burger.moveIngredient(1, 0);

        assertEquals("new sauce", burger.ingredients.get(0).getName());
    }
}
