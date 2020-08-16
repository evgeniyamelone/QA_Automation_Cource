import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingChrome_IT {
    @Test
    public void registration() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement elementFirstName = driver.findElement(By.id("user-name"));
        elementFirstName.click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        WebElement elementPassword = driver.findElement(By.id("password"));
        elementPassword.click();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        WebElement elementSubmit = driver.findElement(By.id("login-button"));
        elementSubmit.click();
        Assert.assertTrue(driver.getPageSource().contains("Product"));
        System.out.println("Text is present");
        driver.close();
    }
}

