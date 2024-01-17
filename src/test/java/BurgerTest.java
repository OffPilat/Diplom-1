import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Юнит-тест модели бургера.
 * Проверка установки булочек.
 * Проверка добавления, перемещения и удаления ингредиентов.
 * Проверка получения чека и информации о бургере.
 */

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun actualResult = burger.bun;
        Bun expectedResult = bun;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Ingredient expectedResult = burger.ingredients.get(0);
        Ingredient actualResult = ingredient;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.addAll(Arrays.asList(ingredient,secondIngredient));
        List<Ingredient> actualResult = new ArrayList<>(Arrays.asList(secondIngredient,ingredient));
        List<Ingredient> expectedResult = burger.ingredients;
        burger.moveIngredient(0, 1);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        Mockito.when(bun.getPrice()).thenReturn(Constants.PRICE_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.PRICE_INGREDIENT);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.ingredients = ingredients;
        Float actualResult = burger.getPrice();
        Float expectedResult = Constants.PRICE_BUN * 2 + Constants.PRICE_INGREDIENT;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        Mockito.when(bun.getName()).thenReturn(Constants.NAME_BUN);
        Mockito.when(ingredient.getName()).thenReturn(Constants.NAME_INGREDIENT);
        Mockito.when(ingredient.getType()).thenReturn(Constants.TYPE_INGREDIENT);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.ingredients = ingredients;
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expectedResult, actualResult);
    }

}
