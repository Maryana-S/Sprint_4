package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок главной страницы "Самокат на пару дней"
    private By mainPageHeader = By.xpath(".//*[contains(@class, 'Home_Header') and contains(text(), 'Самокат')]");
    // Кнопка "Заказать" внизу страницы
    private By orderButtonInBottom = By.xpath(".//*[contains(@class, 'FinishButton')]//button[text() = 'Заказать']");

    // Прокрутка до кнопки "Заказать", ожидание кликабельности и клик по ней
    public void scrollAndClickOrderInBottom() {
        WebElement orderButton = driver.findElement(orderButtonInBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderButton);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderButton));
        orderButton.click();
    }

    // Ожидание загрузки и проверка отображения заголовка главной страницы "Самокат на пару дней"
    public void checkIsVisibleHeader() {
        WebElement pageHeader = driver.findElement(mainPageHeader);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(pageHeader));
        Assert.assertTrue(pageHeader.isDisplayed());
    }

}
