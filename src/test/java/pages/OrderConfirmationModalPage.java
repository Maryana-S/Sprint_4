package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationModalPage {

    private WebDriver driver;

    public OrderConfirmationModalPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок модального окна "Хотите оформить заказ?"
    private By orderConfirmationHeader = By.xpath(".//*[text() = 'Хотите оформить заказ?']");
    // Кнопка "Да"
    private By yesButton = By.xpath(".//button[text() = 'Да']");

    // Ожидание загрузки заголовка формы "Про аренду"
    public void waitForLoadModalPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderConfirmationHeader)));
    }

    // Клик по кнопке "Да"
    public void clickYes() {
        driver.findElement(yesButton).click();
    }

    // Ожидание загрузки модального окна "Хотите оформить заказ?" и клик по кнопке "Да"
    public void waitForLoadAndClickYes() {
        waitForLoadModalPageHeader();
        clickYes();
    }

}
