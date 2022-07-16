package home.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialConfigForPracticeFormWithPageObject;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attach;

import static java.lang.String.format;

public class TestBaseWithPageObject {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        CredentialConfigForPracticeFormWithPageObject credentialConfigForPracticeFormWithPageObject =
                ConfigFactory.create(CredentialConfigForPracticeFormWithPageObject.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

//        gradle clean practiceFormWithPageObjectTests_test -Dbrowser=opera
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");

        String login = credentialConfigForPracticeFormWithPageObject.login();
        String password = credentialConfigForPracticeFormWithPageObject.password();
        String remoteWebDriverURL = System.getProperty("remoteWebDriverURL","selenoid.autotests.cloud/wd/hub");
        Configuration.remote = format("https://" + "%s" + ":" + "%s" + "@" + "%s",
                login,
                password,
                remoteWebDriverURL
        );
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
