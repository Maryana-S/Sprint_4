package ru.praktikum.services.qa.scooter.tests;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.qa.scooter.pages.ImportantQuestionsPage;

import static ru.praktikum.services.qa.scooter.constants.TestData.DROPDOWN_CREDENTIALS;

@RunWith(Parameterized.class)
public class CheckImportantQuestionsDropDown extends BaseTest {

    private final String accordionHeader;
    private final String accordionContent;

    public CheckImportantQuestionsDropDown(String accordionHeader, String accordionContent) {
        this.accordionHeader = accordionHeader;
        this.accordionContent = accordionContent;
    }

    @Parameterized.Parameters(name = "Тестовые данные: заголовок пункта выпадающего списка: \"{0}\", текст выпадающего списка: \"{1}\"")
    public static Object[][] getCredentials() {
        return DROPDOWN_CREDENTIALS;
    }

    @Test
    @Description("Проверка, что при нажатии на стрелку выпадающего списка 'Вопросы о важном' открывается соответствующий текст")
    public void checkDropDownContentTest() {
        ImportantQuestionsPage importantQuestionsPage = new ImportantQuestionsPage(driver);
        importantQuestionsPage.scrollToDropDownHeaderAndClick(accordionHeader);
        importantQuestionsPage.checkIsVisibleContent(accordionHeader);
        importantQuestionsPage.checkContent(accordionHeader, accordionContent);
    }

}
