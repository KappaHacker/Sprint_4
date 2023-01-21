package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Массив с ожидаемыми ответами на вопросы из столбца "Вопросы о важном"
    public final String[] ANSWERS = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
    // Массив локаторов для вопросов из столбца "Вопросы о важном"
    private final By[] LOCATORS_QUESTIONS = {
            By.cssSelector("#accordion__heading-0"),
            By.cssSelector("#accordion__heading-1"),
            By.cssSelector("#accordion__heading-2"),
            By.cssSelector("#accordion__heading-3"),
            By.cssSelector("#accordion__heading-4"),
            By.cssSelector("#accordion__heading-5"),
            By.cssSelector("#accordion__heading-6"),
            By.cssSelector("#accordion__heading-7")
    };
    // Массив локаторов для ответов из столбца "Вопросы о важном"
    //#accordion__panel-0 > p
    private final By[] LOCATORS_ANSWERS = {
            By.cssSelector("#accordion__panel-0 > p"),
            By.cssSelector("#accordion__panel-1 > p"),
            By.cssSelector("#accordion__panel-2 > p"),
            By.cssSelector("#accordion__panel-3 > p"),
            By.cssSelector("#accordion__panel-4 > p"),
            By.cssSelector("#accordion__panel-5 > p"),
            By.cssSelector("#accordion__panel-6 > p"),
            By.cssSelector("#accordion__panel-7 > p"),
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Скрол к указанному вопросу из столбца "Вопросы о важном" с ожиданием до полного его отображения
    public void scrollToAccordionButtons(int locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(LOCATORS_QUESTIONS[locator]));
    }

    // Клик по раскрывабщей кнопке из столбца "Вопросы о важном"
    public void clickToAccordionButton(int locator) {
        driver.findElement(LOCATORS_QUESTIONS[locator]).click();
    }

    // Объединение методов скрола и клика
    public void scrollAndClickToAccordionButton(int locator) {
        scrollToAccordionButtons(locator);
        clickToAccordionButton(locator);
    }

    // Метод возвращающий текст ответа из столбца "Вопросы о важном" (локаторы берем из массива)
    public String getAccordionButtonsText(int number) {
        return driver.findElement(LOCATORS_ANSWERS[number]).getText();
    }
}