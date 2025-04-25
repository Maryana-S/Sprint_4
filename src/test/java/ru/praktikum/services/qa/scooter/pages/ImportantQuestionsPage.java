package ru.praktikum.services.qa.scooter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class ImportantQuestionsPage {

    private WebDriver driver;

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Пункт выпадающего списка в разделе «Вопросы о важном»
    String accordionHeaderXpath = ".//*[@class = 'accordion__button' and contains(text(), '%s')]";
    // Содержимое пункта выпадающего списка в разделе «Вопросы о важном»
    String accordionContentXpath = ".//*[@class = 'accordion__item' and " + accordionHeaderXpath + "]//p";

    // Кликабельный заголовок пункта выпадающего списка "Вопросы о важном"
    private WebElement accordionHeader(String text) {
        String xpath = String.format(accordionHeaderXpath, text);
        return driver.findElement(By.xpath(xpath));
    }

    // Содержимое пункта выпадающего списка "Вопросы о важном" в соответствии с заголовком
    private WebElement accordionContent(String accordingHeaderText) {
        String xpath = String.format(accordionContentXpath, accordingHeaderText);
        return driver.findElement(By.xpath(xpath));
    }

    // Скролл и клик по пункту выпадающего списка "Вопросы о важном"
    public void scrollToDropDownHeaderAndClick(String accordingHeaderText) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", accordionHeader(accordingHeaderText));
        accordionHeader(accordingHeaderText).click();
    }

    //Проверка отображения содержимого выпадающего списка "Вопросы о важном"
    public void checkIsVisibleContent(String accordingHeaderText) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(accordionContent(accordingHeaderText)));
        Assert.assertTrue(accordionContent(accordingHeaderText).isDisplayed());
    }

    // Получение содержимого выпадающего списка "Вопросы о важном"
    public String getDropDownContent(String accordingHeaderText) {
        return accordionContent(accordingHeaderText).getText();
    }

    // Проверка соответствия содержимого пункта выпадающего меню его заголовку
    public void checkContent(String accordingHeaderText, String expectedContent) {
        Assert.assertThat("Содержимое выпадающего списка 'Вопросы о важном' не соответствует ожидаемому",
                getDropDownContent(accordingHeaderText), containsString(expectedContent));
    }

}
