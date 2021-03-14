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
    Faker faker = new Faker();
    public int firstAnswer = faker.number().numberBetween(0, 9);
    public int secondAnswer = faker.number().numberBetween(0, 11);
    public int thirdAnswer = faker.number().numberBetween(12, 16);
    public int fourthAnswer = faker.number().numberBetween(17, 18);

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
