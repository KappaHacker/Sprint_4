package org.example.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public final WebDriver driver;
    public static final String urlDestination = "https://qa-scooter.praktikum-services.ru/";

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    // открываем стр
    public void open() {
        driver.get(urlDestination);
    }
}