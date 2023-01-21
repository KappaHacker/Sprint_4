import org.example.page.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCaseHome extends BaseTest {
    private final int number;

    public TestCaseHome(int number) {
        this.number = number;
    }

    // Подстовляем все 8 вопросов и ответов (через индексы массивов)
    @Parameterized.Parameters(name = "{index}: Тестовые данные массива: ANSWERS[{0}]")
    public static Object[][] getNumber() {
        return new Object[][]{
                {0}, {1}, {2}, {3},
                {4}, {5}, {6}, {7}
        };
    }

    @Test
    public void testAccordionButton() {
        HomePage objHomePage = new HomePage(webDriver);
        objHomePage.open();
        objHomePage.scrollAndClickToAccordionButton(number);

        assertEquals("Text not found or doesn't match", objHomePage.ANSWERS[number], objHomePage.getAccordionButtonsText(number));
    }

}