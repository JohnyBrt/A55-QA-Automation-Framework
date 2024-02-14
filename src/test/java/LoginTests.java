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
    public void loginEmptyEmailPassword() throws InterruptedException {
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();

        Thread.sleep(2000);

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();

    }


    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$tStudent");
        clickSubmit();
        Thread.sleep(2000);

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();
        Thread.sleep(2000);
        //Assertions (Expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        driver.quit();


    }

}

