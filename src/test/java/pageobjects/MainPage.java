package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By signInButtonLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void clickSignInButton() {
        String email = "flynn+" + RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();
    }
}
