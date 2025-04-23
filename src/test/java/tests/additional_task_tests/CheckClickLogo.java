package tests.additional_task_tests;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.MainPage;
import pages.OrderFormPage;
import pages.external_pages.ExternalPage;

import static org.hamcrest.CoreMatchers.containsString;

public class CheckClickLogo {

    private WebDriver driver;

    @Test
    @Description("Проверка перехода на главную страницу при клике на логотип 'Самокат' в хедере")
    public void clickScooterLogoGoToHomePage() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickOrder();

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.waitForLoadFormHeader();

        objHeaderPage.clickScooter();

        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkIsVisibleHeader();
    }

    @Test
    @Description("Проверка перехода на главную страницу Яндекс при клике на логотип 'Яндекс' в хедере")
    public void clickYandexLogoGoToMainYandex() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickYandex();

        ExternalPage externalPage = new ExternalPage(driver);
        externalPage.switchToNewWindow();
        String currentUrl = externalPage.getPageUrl();
        Assert.assertThat("URL текущей страницы отличается от ожидаемого", currentUrl, containsString("ya.ru"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
