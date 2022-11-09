import config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestConfig {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Database database;

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(GET_PRICE_EXPECTED, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(GET_RECEIPT_EXPECTED, burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));
        burger.removeIngredient(0);
        assertEquals(REMOVE_INGREDIENT_EXPECTED, burger.getReceipt());
    }

    @Test
    public void moveIngredientTest() {

        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.moveIngredient(0,1);
        assertEquals(MOVE_INGREDIENT_EXPECTED, burger.getReceipt());

    }
}
