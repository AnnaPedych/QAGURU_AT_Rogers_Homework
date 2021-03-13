package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

@Tag("web")
@Feature("Stores page content tests")
public class StoreSearchTests extends TestBase {
    @Test
    @DisplayName("Open stores search page from main page")
    void openStoresFromMainPageTest() {
        open("");
        $(".rcl-navbar a[title='Find a Store']").click();
        $(".dir-map").shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Open stores search page with direct link")
    void openStoresByDirectLinkTest() {
        open("/stores");
        $(".dir-map").shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Console log should not contain errors")
    void checkConsoleLogErrorsTest() {
        open("/stores");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
