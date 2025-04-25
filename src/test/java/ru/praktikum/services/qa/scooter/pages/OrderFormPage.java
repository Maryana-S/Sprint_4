package ru.praktikum.services.qa.scooter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderFormPage {

    private WebDriver driver;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Все поля формы "Для кого самокат"
    private By allFormFields = By.xpath(".//*[contains(@class, 'Order_Form')]");
    // Заголовок страницы "Для кого самокат"
    private By orderFormHeader = By.xpath(".//*[contains(@class, 'Order_Header') and text() = 'Для кого самокат']");
    // Поле ввода "Имя"
    private By nameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    // Поле ввода "Фамилмя"
    private By surnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    // Поле ввода "Адрес"
    private By addressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    // Поле ввода "Станция метро"
    private By metroField = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");
    // Поле ввода "Телефон"
    private By phoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text() = 'Далее']");
    // Пункт выпадающего списка "Станция метро"
    private By selectMetroOption = By.xpath(".//button[contains(@class, 'Order_SelectOption')]");

    // Ожидание загрузки заголовка формы "Для кого самокат"
    public void waitForLoadFormHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderFormHeader)));
    }

    // Ввод значения в поле "Имя"
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Ввод значения в поле "Фамилия"
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // Ввод значения в поле "Адрес"
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // Ввод названия станции метро и её выбор в выпадающем списке "Станция метро"
    public void chooseMetroStation(String metroStation) {
        driver.findElement(metroField).sendKeys(metroStation);
        WebElement metroOption = driver.findElement(selectMetroOption);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(metroOption));
        metroOption.click();
    }

    // Ввод значения в поле "Телефон"
    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Клик по кнопке "Далее"
    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    // Ожидание загрузки и заполнение формы "Для кого самокат"
    public void fillOrderForm(String name, String surname, String address, String metroStation, String phone) {
        waitForLoadFormHeader();
        setName(name);
        setSurname(surname);
        setAddress(address);
        chooseMetroStation(metroStation);
        setPhone(phone);
    }

    // Получить весь текст формы "Для кого самокат"
    public String getAllTextFromOrderForm() {
        return driver.findElement(allFormFields).getText();
    }

    // Снятие фокуса с полей формы (клик по заголовку страницы)
    public void removeFocusFromFields() {
        driver.findElement(orderFormHeader).click();
    }

    // Проверка отображения сообщения оь ошибке
    public void checkIsVisibleErrorMessage(String actualText, String messageText) {
        Assert.assertThat("Не отображается сообщение об ошибке!", actualText, containsString(messageText));
    }

}
