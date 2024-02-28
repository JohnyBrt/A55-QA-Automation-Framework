import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;

    public WebDriverWait wait;

    public Actions actions;

   // public String url = "http://qa.koel.app/";

    //Data Providers Start
   @DataProvider(name="invalidLoginData")
    public Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"invalid@email.com","invalidPassword"},
                {"ionut.burtoiu@testpro.io",""},
                {"",""},
                {"invalid@email.com","Luca@20222"}
        };
    }



    //Data Providers Ends

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String baseURL){
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        navigateToPage(baseURL);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }

    public void clickSubmit() {
       // WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void providePassword(String password) {
      //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
      passwordField.clear();
      passwordField.sendKeys("Luca@20222");
    }

    public void provideEmail(String email) {
      // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       emailField.click();
       emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

        public void chooseAllSongsList() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='songs'] "))).click();
        }


    }
