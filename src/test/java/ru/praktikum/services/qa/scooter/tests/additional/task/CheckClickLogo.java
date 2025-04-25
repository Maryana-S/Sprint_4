package ru.praktikum.services.qa.scooter.tests.additional.task;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.services.qa.scooter.pages.HeaderPage;
import ru.praktikum.services.qa.scooter.pages.MainPage;
import ru.praktikum.services.qa.scooter.pages.OrderFormPage;
import ru.praktikum.services.qa.scooter.pages.external.ExternalPage;
import ru.praktikum.services.qa.scooter.tests.BaseTest;

import static org.hamcrest.CoreMatchers.containsString;

public class CheckClickLogo extends BaseTest {

    @Test
    @Description("Проверка перехода на главную страницу при клике на логотип 'Самокат' в хедере")
    public void clickScooterLogoGoToHomePageTest() {
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
    public void clickYandexLogoGoToMainYandexTest() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickYandex();

        ExternalPage externalPage = new ExternalPage(driver);
        externalPage.switchToNewWindow();
        String currentUrl = externalPage.getPageUrl();
        Assert.assertThat("URL текущей страницы отличается от ожидаемого", currentUrl, containsString("ya.ru"));
    }
}
