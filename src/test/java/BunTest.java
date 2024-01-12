import org.junit.Test;
import praktikum.Bun;
import praktikum.Constants;

import static org.junit.Assert.assertEquals;

/**
 * Юнит-тест модели булочки для бургера.
 * Проверка название и назначения цены булочки.
 */

public class BunTest {



    @Test
    public void getNameTest() {
        Bun bun = new Bun(Constants.nameBun, Constants.priceBun);
        String actualResult = bun.getName();
        String expectedResult = Constants.nameBun;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(Constants.nameBun, Constants.priceBun);
        Float actualResult = bun.getPrice();
        Float expectedResult = Constants.priceBun;
        assertEquals(expectedResult, actualResult);
    }

}
