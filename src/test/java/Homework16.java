import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {


    @Test
    public void registratioNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Steps
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(5000);
        WebElement registrationField = driver.findElement(By.cssSelector("#app > div > div > form > div:nth-child(5) > a"));
        registrationField.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        Assert.assertTrue(emailField.isDisplayed());
        driver.quit();


    }
}