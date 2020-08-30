package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailFieldLocator = By.xpath("//*[@id=\"email_create\"]");
    private By createAccountButtonLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void startAccountAuth(String email) {
        WebElement emailField = driver.findElement(emailFieldLocator);
        WebElement createAccountButton = driver.findElement(createAccountButtonLocator);
        emailField.sendKeys(email);
        createAccountButton.click();
    }
}
