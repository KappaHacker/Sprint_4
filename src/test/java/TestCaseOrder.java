import org.example.page.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestCaseOrder extends BaseTest {

    private final String FNAME;
    private final String SNAME;
    private final String ADDR;
    private final String METRO;
    private final String NUMBER;
    private final String DATE;
    private final String TIME;
    private final String COMM;

    public TestCaseOrder(String fname, String sname, String addr, String metro, String number, String date, String time, String comm) {
        this.FNAME = fname;
        SNAME = sname;
        ADDR = addr;
        METRO = metro;
        NUMBER = number;
        DATE = date;
        TIME = time;
        COMM = comm;
    }

    @Parameterized.Parameters(name = "{index}: Тестовые данные: {0} - {1} - {2} - {3} - {4} - {5} - {6} - {7}")
    public static Object[][] getNumber() {
        return new Object[][]{
                {"Ирина", "Плохая", "ул. Вашего д.25 кв.5", "Сокольники", "88005553535", "16.07.2022", "сутки", "Приветы проверяющим =)"},
                {"Георгий", "Пензенский", "ул. Паково д.2", "Спортивная", "880055535350", "12.07.2022", "двое суток", ""}
        };
    }

    @Test
    public void testOrderWithSmallButton() {
        OrderPage objOrderPage = new OrderPage(webDriver);
        objOrderPage.open();
        objOrderPage.clickToOrderButtonSmall();
        objOrderPage.orderPageFirstInput(FNAME, SNAME, ADDR, METRO, NUMBER);
        objOrderPage.tapOnBlackCheckBox();
        objOrderPage.orderPageSecondInput(DATE, TIME, COMM);
        objOrderPage.tapToButtonYes();

        assertTrue("Window Order Completed - not found!", objOrderPage.waitForWindowOrderCompleted());
    }

    @Test
    public void testOrderWithBigButton() {
        OrderPage objOrderPage = new OrderPage(webDriver);
        objOrderPage.open();
        objOrderPage.scrollToBigButton();
        objOrderPage.clickToOrderButtonBig();
        objOrderPage.orderPageFirstInput(FNAME, SNAME, ADDR, METRO, NUMBER);
        objOrderPage.tapOnBlackCheckBox();
        objOrderPage.orderPageSecondInput(DATE, TIME, COMM);
        objOrderPage.tapToButtonYes();

        assertTrue("Window Order Completed - not found!", objOrderPage.waitForWindowOrderCompleted());
    }
}