package tests;

import com.codeborne.selenide.Condition;
import customAnnotations.JiraIssue;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

@Tag("web")
@Feature("Stores page content tests")
@Owner("Anna Pedych")
@JiraIssue("QC3-22")
public class StoreSearchTests extends TestBase {
    @Test
    @DisplayName("Open stores search page from main page")
    void openStoresFromMainPageTest() {
        step("Open main page", () -> open(""));
        step("Open stores page", () -> {
            $(".rcl-navbar a[title='Find a Store']").click();
            $(".dir-map").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Open stores search page with direct link")
    void openStoresByDirectLinkTest() {
        step("Open stores page", () -> {
            open("/stores");
            $(".dir-map").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Console log should not contain errors")
    void checkConsoleLogErrorsTest() {
        step("Open stores page", () -> open("/stores"));
        step("Check errors in console", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}
