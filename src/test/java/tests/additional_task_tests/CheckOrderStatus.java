package tests.additional_task_tests;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.TrackPage;

import static org.hamcrest.CoreMatchers.containsString;

public class CheckOrderStatus {

    private WebDriver driver;

    @Test
    @Description("Проверка перехода на страницу 'Статус заказа' и отображения изображения с текстом 'Такого заказа нет'")
    public void checkOrderStatusNotFound() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickOrderStatus();
        String orderNumber = "000000";
        objHeaderPage.setOrderNumber(orderNumber);
        objHeaderPage.clickGo();

        TrackPage objTrackPage = new TrackPage(driver);
        Assert.assertThat(objTrackPage.getPageUrl(), containsString("/track?t=" + orderNumber));
        objTrackPage.checkIsVisibleOrderNotFound();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
