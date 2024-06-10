import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation(){
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='registration']")));
       // WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
        String registrationPageUrl = "https://qa.koel.app/registration";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(registrationPageUrl, actualUrl);

    }
}
