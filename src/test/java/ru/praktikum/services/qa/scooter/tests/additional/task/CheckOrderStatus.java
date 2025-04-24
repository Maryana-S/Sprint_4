package ru.praktikum.services.qa.scooter.tests.additional.task;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.services.qa.scooter.pages.HeaderPage;
import ru.praktikum.services.qa.scooter.pages.TrackPage;
import ru.praktikum.services.qa.scooter.tests.BaseTest;

import static org.hamcrest.CoreMatchers.containsString;

public class CheckOrderStatus extends BaseTest {

    @Test
    @Description("Проверка перехода на страницу 'Статус заказа' и отображения изображения с текстом 'Такого заказа нет'")
    public void checkOrderStatusNotFoundTest() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickOrderStatus();
        String orderNumber = "000000";
        objHeaderPage.setOrderNumber(orderNumber);
        objHeaderPage.clickGo();

        TrackPage objTrackPage = new TrackPage(driver);
        Assert.assertThat(objTrackPage.getPageUrl(), containsString("/track?t=" + orderNumber));
        objTrackPage.checkIsVisibleOrderNotFound();
    }
}
