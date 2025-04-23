package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutOrderPage {

    private WebDriver driver;

    public AboutOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок страницы "Про аренду"
    private By aboutOrderHeader = By.xpath(".//*[contains(@class, 'Order_Header') and text() = 'Про аренду']");
    // Поле ввода "Когда привезти самокат"
    private By whenBringScooterField = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    // Текущая дата в календаре "Когда привезти самокат"
    private By currentDateInCalendar = By.xpath(".//*[contains(@class, 'day--today')]");
    // Выпадающий список "Срок аренды"
    private By rentalPeriodDropDown = By.xpath(".//*[@class = 'Dropdown-control' and ./*[contains(text(), 'Срок аренды')]]");
    // Первая опция в выпадающем списке "Срок аренды"
    private By firstOptionInRentalPeriod = By.className("Dropdown-option");
    // Чекбокс "чёрный жемчуг" в блоке "Цвет самоката"
    private By blackCheckBox = By.id("black");
    // Чекбокс "серая безысходность"в блоке "Цвет самоката"
    private By greyCheckBox = By.id("grey");
    // Поле ввода комментарий
    private By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    // Кнопка "Заказать" под формой "Про аренду"
    private By orderButton = By.xpath(".//*[contains(@class, 'Order_Buttons')]//button[text() = 'Заказать']");

    // Ожидание загрузки заголовка формы "Про аренду"
    public void waitForLoadFormHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(aboutOrderHeader)));
    }

    // Установка текущей даты в поле "Когда привезти самокат"
    public void setCurrentDate() {
        driver.findElement(whenBringScooterField).click();
        WebElement currentDate = driver.findElement(currentDateInCalendar);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(currentDate));
        currentDate.click();
    }

    // Выбор срока аренды в выпадающем списке
    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriodDropDown).click();
        WebElement rentalPeriod = driver.findElement(firstOptionInRentalPeriod);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(rentalPeriod));
        rentalPeriod.click();
    }

    // Выбор опции "черный жемчуг" в блоке цвет самоката
    public void chooseBlackColour() {
        driver.findElement(blackCheckBox).click();
    }

    // Выбор опции "серая безысходность" в блоке цвет самоката
    public void chooseGreyColour() {
        driver.findElement(greyCheckBox).click();
    }

    // Ввод комментария в поле "Комментарий для курьера"
    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // Клик по кнопке "Заказать" под формой "Про аренду"
    public void clickOrder() {
        driver.findElement(orderButton).click();
    }

    // Заполнение обязательных полей формы "Про аренду"
    public void fillRequiredFields() {
        waitForLoadFormHeader();
        setCurrentDate();
        chooseRentalPeriod();
    }

}
