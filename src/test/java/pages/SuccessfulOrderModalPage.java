package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class SuccessfulOrderModalPage {

    private WebDriver driver;

    public SuccessfulOrderModalPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок модального окна "Заказ оформлен"
    private By successfulOrderHeader = By.xpath(".//*[text() = 'Заказ оформлен']");
    // Текст модального окна "Заказ оформлен"
    private By successfulOrderText = By.xpath(".//*[contains(text(), 'Номер заказа')]");


    // Ожидание загрузки заголовка модального окна "Заказ оформлен"
    public void waitForLoadModalPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(successfulOrderHeader)));
    }

    // Получение текста модального окна "Заказ оформлен"
    public String getSuccessfulOrderText() {
        return driver.findElement(successfulOrderText).getText();
    }

    // Ожидание загрузки и получение текста модального окна "Заказ оформлен"
    public String waitForLoadAndGetSuccessfulText() {
        waitForLoadModalPageHeader();
        return getSuccessfulOrderText();
    }

    // Проверка, что текст модального окна "Заказ оформлен" соответствует ожидаемому
    public void checkSuccessfulOrderText(String actualText, String expectedText) {
        Assert.assertThat("Текст модального окна 'Заказ оформлен' не соответствует ожидаемому", actualText, containsString(expectedText));
    }

}
