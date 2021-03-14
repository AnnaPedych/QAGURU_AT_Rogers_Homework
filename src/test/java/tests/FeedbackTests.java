package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
@Feature("Feedback tests")
public class FeedbackTests extends TestBase {
    @Test
    @DisplayName("Feedback form is opened successfully")
    void openFeedbackFormTest() {
        open("");
        $("[alt='Feedback Link']").click();
        switchTo().frame("survey-iframe-SI_cITeM7y1ypmvyDP");
        $("#Questions .QuestionText").shouldHave(matchText("Survey"));
    }

    @Test
    @DisplayName("Feedback form is submitted successfully with only mandatory fields")
    void submitFeedbackFormMandatoryOnlyTest() {
        open("");
        $("[alt='Feedback Link']").click();
        switchTo().frame("survey-iframe-SI_cITeM7y1ypmvyDP");
        $(".q-radio", firstAnswer).click();
        $$(".ChoiceStructure li").get(secondAnswer).$("label").click();
        $$(".ChoiceStructure li").get(thirdAnswer).$("label").click();
        $$(".ChoiceStructure li").get(fourthAnswer).$("label").click();
        $("#NextButton").click();
        $("#EndOfSurvey").shouldHave(matchText("thank you"));
        switchTo().defaultContent();
        $("[alt=Close]").click();
        $(".QSIEmbeddedWindowShadowBox").shouldNotBe(visible);
    }

    @Test
    @DisplayName("Feedback form is submitted with error")
    void negativeSubmitFeedbackFormTest() {
        open("");
        $("[alt='Feedback Link']").click();
        switchTo().frame("survey-iframe-SI_cITeM7y1ypmvyDP");
        $("#NextButton").click();
        $("#Questions .QuestionText").shouldHave(matchText("Survey"));
    }
}
