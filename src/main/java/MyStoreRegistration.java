import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreRegistration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
      //  driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.className("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email_create\"]")));
        String email = "flynn+" + RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        String password = RandomStringUtils.randomAlphanumeric(10);
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_firstname\"]")));

        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Johnny");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Flynn");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        Select day = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        day.selectByValue("14");
        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        month.selectByValue("3");
        Select year = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        year.selectByValue("1983");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("South Africa");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Johannesburg");
        Select state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        state.selectByValue("10");
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(RandomStringUtils.randomNumeric(5));
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"))
                .sendKeys("+" + RandomStringUtils.randomNumeric(10));
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Home");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        driver.findElement(By.xpath("//*[text()[contains(.,'Welcome to your account')]]"));
    }
}
