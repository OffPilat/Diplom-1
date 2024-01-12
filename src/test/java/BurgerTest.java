import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
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


    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Bun bun = new Bun(Constants.nameBun, Constants.priceBun);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actualResult = burger.bun;
        Bun expectedResult = bun;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Ingredient expectedResult = burger.ingredients.get(0);
        Ingredient actualResult = ingredient;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        Ingredient secondIngredient = new Ingredient(Constants.typeSecondIngredient, Constants.nameIngredient, Constants.priceIngredient);
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Ingredient expectedResult = burger.ingredients.get(1);
        Ingredient actualResult = firstIngredient;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        bun = Mockito.mock(Bun.class);
        burger.bun = bun;
        Mockito.when(bun.getPrice()).thenReturn(Constants.priceBun);
        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.priceIngredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.ingredients = ingredients;
        Float actualResult = burger.getPrice();
        Float expectedResult = Constants.priceBun * 2 + Constants.priceIngredient;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn(Constants.nameBun);
        burger.bun = bun;
        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn(Constants.nameIngredient);
        Mockito.when(ingredient.getType()).thenReturn(Constants.typeIngredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        burger.ingredients = ingredients;
        String actualResult = burger.getReceipt();
        assertTrue(actualResult.contains(Constants.nameBun) || actualResult.contains(String.format(Constants.typeIngredient.toString().toLowerCase())) || actualResult.contains(Constants.nameIngredient) || actualResult.contains("Price"));
    }

}
