package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    @Mock
    private Database database;

    List<Bun> exceptedBuns;
    List<Ingredient> exceptedIngredients;

    @Before
    public void setUp() {
        exceptedBuns = new ArrayList<>();
        exceptedBuns.add(new Bun("test bun", 2));

        exceptedIngredients = new ArrayList<>();
        exceptedIngredients.add(new Ingredient(IngredientType.SAUCE, "test sauce", 1));
    }

    @Test
    public void testAvailableBuns() {
        Mockito.when(database.availableBuns()).thenReturn(exceptedBuns);

        assertNotNull(database.availableBuns());
    }

    @Test
    public void testAvailableIngredients() {
        Mockito.when(database.availableIngredients()).thenReturn(exceptedIngredients);

        assertNotNull(database.availableIngredients());
    }
}
