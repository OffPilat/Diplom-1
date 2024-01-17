import org.junit.Test;
import praktikum.Constants;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

/**
 * Юнит-тесты на проверку получения цены, имени и типа ингредиента.
 */

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(Constants.TYPE_INGREDIENT, Constants.NAME_INGREDIENT, Constants.PRICE_INGREDIENT);
        Float actualResult = ingredient.getPrice();
        Float expectedResult = Constants.PRICE_INGREDIENT;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(Constants.TYPE_INGREDIENT, Constants.NAME_INGREDIENT, Constants.PRICE_INGREDIENT);
        String actualResult = ingredient.getName();
        String expectedResult = Constants.NAME_INGREDIENT;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(Constants.TYPE_INGREDIENT, Constants.NAME_INGREDIENT, Constants.PRICE_INGREDIENT);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = Constants.TYPE_INGREDIENT;
        assertEquals(expectedResult, actualResult);
    }
}
