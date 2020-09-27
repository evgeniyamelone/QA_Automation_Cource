package ui.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AccountCreationPage;
import pageobjects.AccountPage;
import pageobjects.AuthenticationPage;
import pageobjects.MainPage;
import ui.ConfigProperties;
import ui.UserAccountsPool;
import ui.UserAccount;
import ui.UserAccountRegistrationForm;
import ui.UserAccountsRegistrationFormPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AuthTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static AuthenticationPage authenticationPage;
    public static AccountCreationPage accountCreationPage;
    public static AccountPage accountPage;
    private static final Logger logger = Logger.getLogger(RegistrationTest.class.getName());
    Map<String, UserAccount> users = new HashMap<>();
    Map<String, UserAccountRegistrationForm> userAccountRegistrationForms = new HashMap<>();
    UserAccountsPool userAccountsPool = new UserAccountsPool(users);
    UserAccountsRegistrationFormPool userAccountRegistrationFormsPool = new UserAccountsRegistrationFormPool(userAccountRegistrationForms);

    @BeforeClass
    public static void setup() {
        logger.info("Setup process started");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        logger.info("ChromeDriver initiated");
        driver = new ChromeDriver();
        logger.info("Read user from Json");
    }

    @Before
    public void init() {
        logger.info("MainPage initiated");
        mainPage = new MainPage(driver);
        logger.info("AuthenticationPage initiated");
        authenticationPage = new AuthenticationPage(driver);
        logger.info("Account initiated");
        accountPage = new AccountPage(driver);
        logger.info("AccountCreationPage initiated");
        accountCreationPage = new AccountCreationPage(driver);
        logger.info("Setup implicitly wait for each method");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("mainpage"));
    }

    @Test
    public void testSuccessfulLogin() {
        logger.info("Email generation");
        String email = "flynn+" + RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        logger.info("Password generation");
        String password = RandomStringUtils.randomAlphanumeric(10);
        logger.info("Postal code generation");
        String postCode = RandomStringUtils.randomNumeric(5);
        logger.info("Mobile phone generation");
        String mobilePhone = "+" + RandomStringUtils.randomNumeric(10);
        logger.info("Opening main page and clicking Sign in button");
        mainPage.clickSignInButton();
        logger.info("Starting account registration with generated email");
        authenticationPage.startAccountAuth(email);
        logger.info("Account registration");
        userAccountRegistrationFormsPool.serialize("src/test/resources/registrationForms.json", "Johnny", "Flynn", password, email, "14",
                "3", "1983", "South Africa", "Johannesburg",
                "10", postCode, mobilePhone, "Home");

        logger.info("Read User Object to Json");
        userAccountsPool.serialize("src/test/resources/accountData.json", email, password);
        logger.info("Read Json to User Object");
        userAccountsPool.deserialize("src/test/resources/accountData.json");
        logger.info("Read Json to Registration Form Object");
        userAccountRegistrationFormsPool.deserialize("src/test/resources/registrationForms.json");

        logger.info("Get User from User Account Pool");
        UserAccount user = userAccountsPool
                .getUser("src/test/resources/accountData.json");

        accountCreationPage.createAccount(userAccountRegistrationFormsPool
                .getUserRegistrationForm("src/test/resources/registrationForms.json"));
        logger.info("Signing out");
        accountPage.signOut();
        logger.info("Opening main page and clicking Sign in button");
        mainPage.clickSignInButton();

        logger.info("Sign In");
        authenticationPage.logIn(user.getEmail(), user.getPassword());
        logger.info("Account registration verification");
        Assert.assertEquals("Johnny Flynn",
                driver.findElement(By.xpath("//*[contains(@title, 'View my customer account')]")).getText());
    }

    @AfterClass
    public static void tearDown() {
        logger.info("Signing out");
        accountPage.signOut();
        logger.info("Closing browser");
        driver.quit();
    }
}
