package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Main page layout tests")
@Owner("Anna Pedych")
public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Page should have Covid Alert")
    @Tag("deprecated")
    @Disabled
    void checkCovidNoticePresentTest() {
        step("Open main page", () -> open(""));
        step("Verify Covid Alert is present", () -> $("div[aria-live=polite] p strong").shouldHave(text("COVID-19")));
    }

    @Test
    @DisplayName("Page blocks should be loaded")
    void checkAllBlocksLoadedTest() {
        step("Open main page", () -> open(""));
        step("Verify page layout", () -> {
            $(".rcl-navbar").shouldBe(visible);
            $(".rcl-navmain").shouldBe(visible);
            $(".jsUiBlockAlert").shouldBe(visible);
            $(".jsUiBlockCarousel").shouldBe(visible);
            $(".jsUiBlockTabs").shouldBe(visible);
            $(".dsa-banner span").find(byText("Learn more")).shouldBe(visible);
            $(byText("More reasons to choose Rogers")).shouldBe(visible);
            $(".jsUiBlockTiles").shouldBe(visible);
            $("#footer").shouldBe(visible);
            $("[alt='Feedback Link']").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        step("Open main page", () -> open(""));
        step("Switch to French version", () -> {
            $(".rcl-navbar a[title=Français]").click();
            $(".rcl-navbar a[title=English]").shouldBe(visible);
            $(".rcl-header-navigation span").shouldHave(text("Magasiner"));
        });
    }
}