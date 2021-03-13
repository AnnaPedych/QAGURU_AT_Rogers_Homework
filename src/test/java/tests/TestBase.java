package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static helpers.DriverHelper.configureDriver;

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        configureDriver();
        Configuration.timeout = 8000;
    }
}
