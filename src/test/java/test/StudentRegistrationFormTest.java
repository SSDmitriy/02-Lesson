package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    /**
     * @BeforAll
     * @BeforeEach
     * @Test
     * @AfterEach
     * @BeforeEach
     * @Test
     * @AfterEach
     * @AfterAll
     */

    static Logger logger = LoggerFactory.getLogger(StudentRegistrationFormTest.class);

    @BeforeAll
    static void setUpConfig() {
        logger.info("@BeforeAll");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    String urlForTest = "https://demoqa.com/automation-practice-form";

    @Test
    void checkRegistrationForm() {
    open(urlForTest);

        String firstNameForTest = "Darth";
        String lastNameForTest = "Vader";
        String emailForTest = "Vader@mail.ru";
        String phoneNumberForTest = "9876543210";
        String dobForTest = "01 Oct 1977";
        String subjectsForTest = "Arts, Biology, Physics";




        $("[id=firstName]").setValue(firstNameForTest);
        $("#lastName").setValue(lastNameForTest);
        $("#userEmail").setValue(emailForTest);
        $("#userEmail").setValue(emailForTest);

        //Здесь неясно, как кликнуть
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue(phoneNumberForTest);
        $("#dateOfBirthInput").setValue(dobForTest);

        //subjectsContainer
//        hobbies-checkbox-1
//        hobbies-checkbox-3
//        uploadPicture



    }
/*
    @BeforeEach
    void openGooglePage() {
        logger.info("@BeforeEach");
        open("https://www.google.com");
    }

    @AfterEach
    void closeBrowser() {
        logger.info("@AfterEach");
        closeWebDriver();
    }

    @Test
    void wikipediaSearchTest() {
        $(byName("q")).setValue("Wikipedia").pressEnter();
        $("#search").shouldHave(text("Wikipedia.org"));
    }

    @Test
    void selenideSearchTest() {
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
*/
}
