import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation() throws InterruptedException {
        //Precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Step 1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
        Thread.sleep(2000);
        //Expected results - Assertions
        String registrationPageUrl = "https://qa.koel.app/registration";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(registrationPageUrl, actualUrl);
        Thread.sleep(5000);
        //Quit browser
        driver.quit();

    }
}
