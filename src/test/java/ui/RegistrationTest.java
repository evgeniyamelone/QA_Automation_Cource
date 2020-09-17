package ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AccountCreationPage;
import pageobjects.AccountPage;
import pageobjects.AuthenticationPage;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static AuthenticationPage authenticationPage;
    public static AccountCreationPage accountCreationPage;
    public static AccountPage accountPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("mainpage"));
    }

    @Test
    public void testSuccessfulRegistration() {
        String email = "flynn+" + RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        String password = RandomStringUtils.randomAlphanumeric(10);
        String postCode = RandomStringUtils.randomNumeric(5);
        String mobilePhone = "+" + RandomStringUtils.randomNumeric(10);
        UserAccount user = new UserAccount(email, password);
        mainPage.clickSignInButton();
        authenticationPage.startAccountAuth(email);
        accountCreationPage.createAccount(new UserAccountRegistrationForm("Johnny", "Flynn", password, email,"14",
                "3", "1983", "South Africa", "Johannesburg",
                "10", postCode, mobilePhone, "Home"));

        Assert.assertEquals("Johnny Flynn",
                driver.findElement(By.xpath("//*[contains(@title, 'View my customer account')]")).getText());
    }

    @AfterEach
    public static void tearDown() {
        accountPage.signOut();
        driver.quit();
    }
}

