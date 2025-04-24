package ru.praktikum.services.qa.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.praktikum.services.qa.scooter.constants.Url.MAIN_URL;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void openMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
