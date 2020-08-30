package ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AccountCreationPage;
import pageobjects.AuthenticationPage;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static AuthenticationPage authenticationPage;
    public static AccountCreationPage accountCreationPage;

    @BeforeClass
    public static void setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("mainpage"));
        mainPage = new MainPage(driver);
    }

    @Test
    public static void testSuccessfulRegistration() {
        String email = "flynn+" + RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        String password = RandomStringUtils.randomAlphanumeric(10);
        String postCode = RandomStringUtils.randomNumeric(5);
        String mobilePhone = "+" + RandomStringUtils.randomNumeric(10);
        mainPage.clickSignInButton();
        authenticationPage.startAccountAuth(email);
        accountCreationPage.createAccount("Johnny", "Flynn", password, "14",
                "03", "1983", "South Africa", "Johannesburg",
                "10", postCode, mobilePhone, "Home");
    Assertions.;
    }
}
