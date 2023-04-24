package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DatabaseCreateTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testCreateDatabaseShowsThreeBuns() {
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void testCreateDatabaseShowsSixIngredients() {
        assertEquals(6, database.availableIngredients().size());
    }

    @Test
    public void testCreateDatabaseShowsThreeSauce() {
        List<Ingredient> exceptedSauces = database.availableIngredients().stream()
                .filter(i -> i.type == IngredientType.SAUCE)
                .collect(Collectors.toList());

        assertEquals(3, exceptedSauces.size());
    }

    @Test
    public void testCreateDatabaseShowsThreeFilling() {
        List<Ingredient> exceptedFilling = database.availableIngredients().stream()
                .filter(i -> i.type == IngredientType.FILLING)
                .collect(Collectors.toList());

        assertEquals(3, exceptedFilling.size());
    }
}
