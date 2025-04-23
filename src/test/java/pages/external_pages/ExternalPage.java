package pages.external_pages;

import org.openqa.selenium.WebDriver;

public class ExternalPage {

    private WebDriver driver;

    public ExternalPage(WebDriver driver) {
        this.driver = driver;
    }

    // Переход в новое окно
    public void switchToNewWindow() {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    // Получение URL страницы
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
