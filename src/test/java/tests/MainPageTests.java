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
    }}

