package tests.additional_task_tests;

import jdk.jfr.Description;
import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OrderFormPage;

public class CheckErrorMessageInOrderForm {

    private WebDriver driver;

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Имя' формы 'Для кого самокат'")
    public void checkErrorMessageNameField() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setName(RandomString.make(15));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректное имя");

    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Фамилия' формы 'Для кого самокат'")
    public void checkErrorMessageSurnameField() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setSurname(RandomString.make(15));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректную фамилию");

    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Адрес' формы 'Для кого самокат'")
    public void checkErrorMessageAddressField() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setAddress(RandomString.make(30));
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректный адрес");

    }

    @Test
    @Description("Проверка отображения ошибки при некорректном заполнении поля 'Телефон' формы 'Для кого самокат'")
    public void checkErrorMessagePhoneField() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        OrderFormPage objOrderFormPage = new OrderFormPage(driver);
        objOrderFormPage.setPhone("0000");
        objOrderFormPage.removeFocusFromFields();
        String allFormText = objOrderFormPage.getAllTextFromOrderForm();
        objOrderFormPage.checkIsVisibleErrorMessage(allFormText, "Введите корректный номер");

    }

    @Test
    @Description("Проверка отображения ошибки при незаполненном поле 'Станция метро' формы 'Для кого самокат'")
    public void checkErrorMessageMetroField() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");

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
