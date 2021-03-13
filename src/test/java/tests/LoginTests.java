package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Successful Login as Pay As You Go Customer")
    void loginPayAsYouGoTest() {
        open("");
        $(".rcl-navbar a[title='Sign in']").click();
        $("#username").setValue("p.ann@i.ua");
        $("#password").setValue("TestAccount1");
        $(".signInButton button").click();
        $(".top_intro_section h1").shouldHave(text("Welcome,"));
        $(".link_intro_section span").shouldHave(text("Where can I find my account number?"));
    }
}
