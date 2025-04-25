package ru.praktikum.services.qa.scooter.tests.additional.task;

import jdk.jfr.Description;
import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.services.qa.scooter.pages.OrderFormPage;

import static ru.praktikum.services.qa.scooter.constants.Url.ORDER_URL;

public class CheckErrorMessageInOrderForm {

    private WebDriver driver;

    @Before
    public void openOrderPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ORDER_URL);
    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Имя' формы 'Для кого самокат'")
    public void checkErrorMessageNameFieldTest() {
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setName(RandomString.make(15));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректное имя");
    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Фамилия' формы 'Для кого самокат'")
    public void checkErrorMessageSurnameFieldTest() {
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setSurname(RandomString.make(15));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректную фамилию");
    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Адрес' формы 'Для кого самокат'")
    public void checkErrorMessageAddressFieldTest() {
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setAddress(RandomString.make(30));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректный адрес");
    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Телефон' формы 'Для кого самокат'")
    public void checkErrorMessagePhoneFieldTest() {
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setPhone("0000");
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректный номер");
    }

    @Test
    @Description("Проверка отображения ошибки при незаполненном поле 'Станция метро' формы 'Для кого самокат'")
    public void checkErrorMessageMetroFieldTest() {
        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.clickNext();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Выберите станцию");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
