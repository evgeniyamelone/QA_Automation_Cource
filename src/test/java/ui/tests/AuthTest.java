package ui.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AccountPage;
import pageobjects.AuthenticationPage;
import pageobjects.MainPage;
import ui.ConfigProperties;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AuthTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static AuthenticationPage authenticationPage;
    public static AccountPage accountPage;
    private static final Logger logger = Logger.getLogger(RegistrationTest.class.getName());

    @BeforeClass
    public static void setup() {
        logger.info("Setup process started");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        logger.info("ChromeDriver initiated");
        driver = new ChromeDriver();
    }

    @Before
    public void init() {
        logger.info("MainPage initiated");
        mainPage = new MainPage(driver);
        logger.info("AuthenticationPage initiated");
        authenticationPage = new AuthenticationPage(driver);
        logger.info("Account initiated");
        accountPage = new AccountPage(driver);
        logger.info("Setup implicitly wait for each method");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("mainpage"));
    }

    @Test
    public void testSuccessfulLogin() {
}
}
