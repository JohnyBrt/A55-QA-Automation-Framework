import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
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
      // WebDriverManager.chromedriver().setup();
       //WebDriverManager.firefoxdriver().setup();
      // WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String baseURL) throws MalformedURLException {
        // Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        driver = pickBrowser(System.getProperty("browser"));
        System.out.println();
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        navigateToPage(baseURL);

    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL ="http://192.168.1.158:4444/";
       switch (browser){
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();
           case "MicrosoftEdge":
               WebDriverManager.edgedriver().setup();
               EdgeOptions  edgeOptions = new EdgeOptions();
               edgeOptions.addArguments("--remote-allow-origins=*");
               return driver = new EdgeDriver(edgeOptions);
           case "Safari":
               WebDriverManager.safaridriver().setup();
               return driver = new SafariDriver();
            case "grid-ege":
               caps.setCapability("browserName","MicrosoftEdge");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
          case "grid-firefox":
               caps.setCapability("browserName","firefox");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           case "grid-chrome":
               caps.setCapability("browserName","chrome");
               return driver =  new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           case "grid-safari":
               caps.setCapability("browserName","safari");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           default:
               WebDriverManager.chromedriver().setup();
               ChromeOptions chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("==remote-allow-origins=*");
               return driver = new ChromeDriver(chromeOptions);

       }


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
