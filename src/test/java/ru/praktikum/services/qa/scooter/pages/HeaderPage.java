package ru.praktikum.services.qa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//*[contains(@class, 'Header')]//button[text() = 'Заказать']");
    // Логотип "Яндекс" в хедере
    private By yandexLogo = By.xpath(".//img[@alt = 'Yandex']");
    // Логотип "Самокат" в хедере
    private By scooterLogo = By.xpath(".//img[@alt = 'Scooter']");
    // Кнопка "Статус заказа в хедере"
    private By orderStatusButton = By.xpath(".//button[text() = 'Статус заказа']");
    // Поле "Введите номер заказа"
    private By orderNumberInput = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    // Кнопка "Go!"
    private By goButton = By.xpath(".//button[text() = 'Go!']");

    // Ожидание кликабельности и клик по кнопке "Заказать"
    public void clickOrder() {
        WebElement orderButton = driver.findElement(this.orderButton);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderButton));
        orderButton.click();
    }

    // Клик по логотипу "Самокат"
    public void clickScooter() {
        driver.findElement(scooterLogo).click();
    }

    // Клик по логотипу "Яндекс"
    public void clickYandex() {
        driver.findElement(yandexLogo).click();
    }

    // Клик по кнопке "Статус заказа"
    public void clickOrderStatus() {
        driver.findElement(orderStatusButton).click();
    }

    // Ожидание отображения и ввод номера заказа в поле
    public void setOrderNumber(String orderNumber) {
        WebElement orderNumberField = driver.findElement(orderNumberInput);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(orderNumberField));
        orderNumberField.sendKeys(orderNumber);
    }

    // Клик по кнопке "Go!"
    public void clickGo() {
        driver.findElement(goButton).click();
    }

}
