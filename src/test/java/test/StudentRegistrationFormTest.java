package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

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

        //test data
        String firstNameForTest = "Darth";
        String lastNameForTest = "Vader";
        String emailForTest = "Vader@mail.ru";
        String phoneNumberForTest = "9876543210";
        String dobForTest = "01 Oct 1977";
        String subjectOneForTest = "Arts";
        String subjectTwoForTest = "Biology";
        String subjectThreeForTest = "Physics";
        File testJpgFile = new File("src/test/testData/testJPG.jpg");
        String currentAddress = "Text for textarea \"Current Address\"";
        String stateForTest = "NCR";
        String cityForTest = "Guardon";

//find and fill elements
        // Name
        $("[id=firstName]").setValue(firstNameForTest);
        $("#lastName").setValue(lastNameForTest);
        $("#userEmail").setValue(emailForTest);
        $("#userEmail").setValue(emailForTest);

        //radiobutton "Gender"
        $("[for='gender-radio-3']").click();

        $("#userNumber").setValue(phoneNumberForTest);
        $("#dateOfBirthInput").setValue(dobForTest).pressEnter();

        $("#subjectsInput").setValue(subjectOneForTest).pressEnter();
        $("#subjectsInput").setValue(subjectTwoForTest).pressEnter();
        $("#subjectsInput").setValue(subjectThreeForTest).pressEnter();

        //checkboxes (2 from 3)
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();

        //upload file
        $("#uploadPicture").uploadFile(testJpgFile);

        $("#currentAddress").setValue(currentAddress);

        //dropdown select
        $("#react-select-3-input").setValue(stateForTest).pressEnter();
        $("#react-select-4-input").setValue(cityForTest).pressEnter();

        //press SUBMIT
        $("#submit").click();

//checking data
        $(".table-responsive").shouldHave(
                text(firstNameForTest),
                text(lastNameForTest),
                text(emailForTest),
                text(phoneNumberForTest),
                text(dobForTest),
                text(subjectOneForTest),
                text(subjectTwoForTest),
                text(subjectThreeForTest),
                text("testJPG.jpg"),
                text(currentAddress),
                text(stateForTest),
                text(cityForTest)
        );

        $("#closeLargeModal").click();

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
