import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

/**
 * Параметризованный юнит-тест типов ингредиентов.
 */

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public IngredientType typeOfIngredient;
    @Parameterized.Parameter(1)
    public String valueOfIngredient;

    @Parameterized.Parameters()
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void IngredientTypeIsFoundTest() {
        IngredientType actualResult = typeOfIngredient;
        IngredientType expectedResult = IngredientType.valueOf(valueOfIngredient);
        assertEquals(expectedResult, actualResult);
    }
}
