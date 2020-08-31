package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstNameFieldLocator = By.xpath("//*[@id=\"customer_firstname\"]");
    private By lastNameFieldLocator = By.xpath("//*[@id=\"customer_lastname\"]");
    private WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
    private Select dayDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
    private Select monthDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
    private Select yearDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
    private WebElement addressField = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
    private WebElement cityField = driver.findElement(By.xpath("//*[@id=\"city\"]"));
    private Select stateDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
    private WebElement postCodeField = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
    private WebElement mobilePhoneField = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
    private WebElement aliasField = driver.findElement(By.xpath("//*[@id=\"alias\"]"));
    private WebElement submitAccountButton = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void createAccount(String firstName, String lastName, String password,
                              String day, String month, String year, String country, String city,
                              String state, String postCode, String mobile, String alias) {
        WebElement firstNameField = driver.findElement(firstNameFieldLocator);
        WebElement lastNameField = driver.findElement(lastNameFieldLocator);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        dayDropdown.selectByValue(day);
        monthDropdown.selectByValue(month);
        yearDropdown.selectByValue(year);
        addressField.sendKeys(country);
        cityField.sendKeys(city);
        stateDropdown.selectByValue(state);
        postCodeField.sendKeys(postCode);
        mobilePhoneField.sendKeys("+" + mobile);
        aliasField.sendKeys(alias);
        submitAccountButton.click();
    }
}
