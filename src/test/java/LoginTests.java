import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword(){
        //Pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Step 1 : Open Browser
        String url = "http://qa.koel.app/";
        driver.get(url);
        //Step 2: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        // Step 3: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        //Step $: Click on login Button
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        //Assertion
        WebElement avatarIcon =  driver.findElement(By.cssSelector("img[class='avatar]"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        driver.quit();

    }


}
