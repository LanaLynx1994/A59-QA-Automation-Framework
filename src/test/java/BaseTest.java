import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
   // public ChromeOptions options = new ChromeOptions();
    public FirefoxOptions options = new FirefoxOptions();
  //String url = "https://qa.koel.app/";
    public static WebDriverWait wait = null;
    public Wait<WebDriver> fluentWait;

    public static Actions actions = null;



    @BeforeSuite
    static void setupClass() {

       // WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error

       // options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
      //  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = pickBrowser(System.getProperty("browser"));
      //driver = new ChromeDriver(options);
       // driver = new FirefoxDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      fluentWait = new FluentWait<WebDriver>(driver)
              .withTimeout(Duration.ofSeconds(5))
              .pollingEvery(Duration.ofMillis(200)).ignoring(ElementNotInteractableException.class);
      navigateToPage(baseURL);
      actions = new Actions(driver);
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.122:4444";
        switch (browser){
            case "firefox": //gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless", "--disable-gpu", "-private");
              //  FirefoxProfile firefoxProfile = new FirefoxProfile();
               // firefoxProfile.setPreference("dom.webnotifications.enabled", false);
                return driver = new FirefoxDriver();
            case "safari": //gradle clean test -Dbrowser=safari
                WebDriverManager.safaridriver().setup();
                SafariOptions safariOptions = new SafariOptions();
               return driver = new SafariDriver();
            case "MicrosoftEdge": //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

                //Grid Cases
            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-safari": //gradle clean test -Dbrowser=grid-safari
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            default: //gradle clean test
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    @AfterMethod
    public void clearBrowser(){

        driver.quit();
    }

    public void navigateToPage(String url) {

        driver.get(url);

    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        //Thread.sleep(2000);
    }

    public void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
       // WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
      // Thread.sleep(2000);
    }
}