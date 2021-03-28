package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}
