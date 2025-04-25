package ru.praktikum.services.qa.scooter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {

    private WebDriver driver;

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    // Изображение с текстом "Такого заказа нет"
    private By orderNotFoundImg = By.xpath(".//img[@alt = 'Not found']");

    // Проверка отображения изображения с текстом "Такого заказа нет"
    public void checkIsVisibleOrderNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(driver.findElement(orderNotFoundImg)));
        Assert.assertTrue(driver.findElement(orderNotFoundImg).isDisplayed());
    }

    // Получение URL страницы
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
