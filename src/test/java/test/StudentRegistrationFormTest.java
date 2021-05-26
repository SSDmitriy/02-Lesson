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
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    static Logger logger = LoggerFactory.getLogger(StudentRegistrationFormTest.class);

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

    @BeforeAll
    static void setUpConfig() {
        logger.info("@BeforeAll");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

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

//TEST_DATA
        String urlForTest = "https://demoqa.com/automation-practice-form";

        String firstNameForTest = "Darth";
        String lastNameForTest = "Vader";
        String emailForTest = "Vader@mail.ru";
        String phoneNumberForTest = "9876543210";

        String dateForTest = "25 May,1977";
        String monthForTest = "May";
        String yearForTest = "1977";

        String subjectOneForTest = "Arts";
        String subjectTwoForTest = "Biology";
        String subjectThreeForTest = "Physics";

        String fileNameForTest = "testJPG.jpg";
            File testJpgFile = new File("src/test/testData/" + fileNameForTest);

        String currentAddress = "Just a text for textarea \"Current Address\"";
        String stateForTest = "NCR";
        String cityForTest = "Gurgaon";

//end of TEST_DATA


//begin TEST
    @Test
    void checkRegistrationForm() {
        open(urlForTest);

//find and fill elements
        // Name
        $("[id=firstName]").setValue(firstNameForTest);
        $("#lastName").setValue(lastNameForTest);
        $("#userEmail").setValue(emailForTest);
        $("#userEmail").setValue(emailForTest);

//radiobutton "Gender"
        $("[for='gender-radio-3']").click();

//phone number
        $("#userNumber").setValue(phoneNumberForTest);

//clicking on dob
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthForTest);
        $(".react-datepicker__year-select").selectOption(yearForTest);
        //здесь слабое место - дата захардкожена
        $("[aria-label='Choose Wednesday, May 25th, 1977']").click();

//subjects in tokenfield
        $("#subjectsInput").setValue(subjectOneForTest).pressEnter();
        $("#subjectsInput").setValue(subjectTwoForTest).pressEnter();
        $("#subjectsInput").setValue(subjectThreeForTest).pressEnter();

//hobby-checkboxes (2 from 3)
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();

//upload file
        $("#uploadPicture").uploadFile(testJpgFile);

//fill textbox
        $("#currentAddress").setValue(currentAddress);

//dropdown select state&city
        $("#react-select-3-input").setValue(stateForTest).pressEnter();
        $("#react-select-4-input").setValue(cityForTest).pressEnter();

//press SUBMIT
        $("#submit").click();


//CHECKING_DATA
        $(".table-responsive").shouldHave(text(firstNameForTest));
        $(".table-responsive").shouldHave(text(emailForTest));
        $(".table-responsive").shouldHave(text(phoneNumberForTest));
        $(".table-responsive").shouldHave(text(dateForTest));
        $(".table-responsive").shouldHave(text(firstNameForTest));
        $(".table-responsive").shouldHave(text(lastNameForTest));
        $(".table-responsive").shouldHave(text(emailForTest));
        $(".table-responsive").shouldHave(text(phoneNumberForTest));
        $(".table-responsive").shouldHave(text(dateForTest));
        $(".table-responsive").shouldHave(text(subjectOneForTest));
        $(".table-responsive").shouldHave(text(subjectTwoForTest));
        $(".table-responsive").shouldHave(text(subjectThreeForTest));
        $(".table-responsive").shouldHave(text(fileNameForTest));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(stateForTest));
        $(".table-responsive").shouldHave(text(cityForTest));

//close modal window
        $("#closeLargeModal").click();

    }
}
