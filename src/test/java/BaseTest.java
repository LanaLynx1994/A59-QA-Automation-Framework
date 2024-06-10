import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
  //String url = "https://qa.koel.app/";
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;



    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL){
        //      Added ChromeOptions argument below to fix websocket error

        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      fluentWait = new FluentWait<WebDriver>(driver)
              .withTimeout(Duration.ofSeconds(5))
              .pollingEvery(Duration.ofMillis(200)).ignoring(ElementNotInteractableException.class);
      navigateToPage(baseURL);
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