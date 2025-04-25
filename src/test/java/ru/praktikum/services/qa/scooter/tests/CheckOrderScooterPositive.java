package ru.praktikum.services.qa.scooter.tests;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.qa.scooter.pages.*;

import static ru.praktikum.services.qa.scooter.constants.TestData.ORDER_FORM_CREDENTIALS;

@RunWith(Parameterized.class)
public class CheckOrderScooterPositive extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;

    public CheckOrderScooterPositive(String name, String surname, String address, String metroStation, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя - \"{0}\", фамилия - \"{1}\", адрес - \"{2}\", станция метро - \"{3}\", номер телефона - \"{4}\"")
    public static Object[][] getCredentials() {
        return ORDER_FORM_CREDENTIALS;
    }

    @Test
    @Description("Проверка прохождения позитивного сценария заказа самоката. Точка входа: кнопка 'Заказать' в хедере. Заполнены все поля формы")
    public void orderScooterFromHeaderPositiveTest() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickOrder();

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.fillOrderForm(name, surname, address, metroStation, phone);
        objOrderFormPage.clickNext();

        AboutOrderPage objAboutOrderPage = new AboutOrderPage(driver);
        objAboutOrderPage.fillRequiredFields();
        objAboutOrderPage.chooseBlackColour();
        objAboutOrderPage.chooseGreyColour();
        objAboutOrderPage.enterComment("Самокат самокат самокат самокат самокат");
        objAboutOrderPage.clickOrder();

        OrderConfirmationModalPage objOrderConfirmationModalPage = new OrderConfirmationModalPage(driver);
        objOrderConfirmationModalPage.waitForLoadAndClickYes();

        SuccessfulOrderModalPage objSuccessfulOrderModalPage = new SuccessfulOrderModalPage(driver);
        String successfulOrderMessage = objSuccessfulOrderModalPage.waitForLoadAndGetSuccessfulText();
        String expectedSuccessfulText = "Запишите его:\nпригодится, чтобы отслеживать статус";
        objSuccessfulOrderModalPage.checkSuccessfulOrderText(successfulOrderMessage, expectedSuccessfulText);
    }

    @Test
    @Description("Проверка прохождения позитивного сценария заказа самоката. Точка входа: кнопка 'Заказать' внизу главной страницы. Заполнены только обязательные поля формы")
    public void orderScooterFromBottomPositiveTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollAndClickOrderInBottom();

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.fillOrderForm(name, surname, address, metroStation, phone);
        objOrderFormPage.clickNext();

        AboutOrderPage objAboutOrderPage = new AboutOrderPage(driver);
        objAboutOrderPage.fillRequiredFields();
        objAboutOrderPage.clickOrder();

        OrderConfirmationModalPage objOrderConfirmationModalPage = new OrderConfirmationModalPage(driver);
        objOrderConfirmationModalPage.waitForLoadAndClickYes();

        SuccessfulOrderModalPage objSuccessfulOrderModalPage = new SuccessfulOrderModalPage(driver);
        String successfulOrderMessage = objSuccessfulOrderModalPage.waitForLoadAndGetSuccessfulText();
        String expectedSuccessfulText = "Запишите его:\nпригодится, чтобы отслеживать статус";
        objSuccessfulOrderModalPage.checkSuccessfulOrderText(successfulOrderMessage, expectedSuccessfulText);
    }

}
