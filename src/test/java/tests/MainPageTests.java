package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class MainPageTests extends TestBase{
    @Test
    @DisplayName("Page should have Covid Notice")
    void checkCovidNoticePresentTest() {
        open("");
        $("div[aria-live=polite] p strong").shouldHave(text("COVID-19"));
    }

    @Test
    @DisplayName("Page blocks should be loaded")
    void checkAllBlocksLoadedTest() {
        open("");
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
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        open("");
        $(".rcl-navbar a[title=Français]").click();
        $(".rcl-navbar a[title=English]").shouldBe(visible);
        $(".rcl-header-navigation span").shouldHave(text("Magasiner"));
    }
}

