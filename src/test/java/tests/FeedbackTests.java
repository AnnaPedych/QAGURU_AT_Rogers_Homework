package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Feedback tests")
@Owner("Anna Pedych")
public class FeedbackTests extends TestBase {
    @Test
    @DisplayName("Feedback form is opened successfully")
    void openFeedbackFormTest() {
        step("Open main page", () -> open(""));
        step("Open feedback form", () -> {
            $("[alt='Feedback Link']").click();
            switchTo().frame($(".QSIEmbeddedTarget iframe"));
            $("#Questions .QuestionText").shouldHave(matchText("Survey"));
        });}

    @Test
    @DisplayName("Feedback form is submitted successfully with only mandatory fields")
    void submitFeedbackFormMandatoryOnlyTest() {
        step("Open main page", () -> open(""));
        step("Open feedback form", () -> {
            $("[alt='Feedback Link']").click();
            switchTo().frame($(".QSIEmbeddedTarget iframe"));
        });
        step("Populate questionnaire", () -> {
            $(".q-radio", TestData.firstAnswer).click();
            System.out.print(TestData.firstAnswer);
            $$(".ChoiceStructure li").get(TestData.secondAnswer).$("label").click();
            $$(".ChoiceStructure li").get(TestData.thirdAnswer).$("label").click();
            $$(".ChoiceStructure li").get(TestData.fourthAnswer).$("label").click();});
        step("Submit feedback form", () -> {
            $("#NextButton").click();
            $("#EndOfSurvey").shouldHave(matchText("thank you"));});
        step("Close feedback form", () -> {
            switchTo().defaultContent();
            $("[alt=Close]").click();
            $(".QSIEmbeddedWindowShadowBox").shouldNotBe(visible);});
    }

    @Test
    @DisplayName("Feedback form is submitted with error")
    void negativeSubmitFeedbackFormTest() {
        step("Open main page", () -> open(""));
        step("Open feedback form", () -> {
            $("[alt='Feedback Link']").click();
            switchTo().frame($(".QSIEmbeddedTarget iframe"));
        });
        step("Submit feedback form", () -> $("#NextButton").click());
        step("Verify system throws validation error", () -> {
        $("#Questions .QuestionText").shouldHave(matchText("Survey"));});
    }
}
