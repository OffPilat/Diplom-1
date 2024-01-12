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
        Ingredient ingredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        Float actualResult = ingredient.getPrice();
        Float expectedResult = Constants.priceIngredient;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        String actualResult = ingredient.getName();
        String expectedResult = Constants.nameIngredient;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(Constants.typeIngredient, Constants.nameIngredient, Constants.priceIngredient);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = Constants.typeIngredient;
        assertEquals(expectedResult, actualResult);
    }
}
