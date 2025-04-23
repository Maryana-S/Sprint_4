package tests;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@RunWith(Parameterized.class)
public class OrderScooterPositive {

    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;

    public OrderScooterPositive(String name, String surname, String address, String metroStation, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Тест", "Тестов", "г. Тест, ул. Тестовая, д.2", "Рязанский проспект", "89999999999"},
                {"Виктория", "Сидорова", "г. Москва, ул. Садовая, д. 187", "ВДНХ", "+79999999999"},
        };
    }

    @Test
    @Description("Проверка прохождения позитивного сценария заказа самоката. Точка входа: кнопка 'Заказать' в хедере. Заполнены все поля формы")
    public void orderScooterFromHeaderPositive() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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
    public void orderScooterFromBottomPositive() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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

    @After
    public void tearDown() {
        driver.quit();
    }

}
