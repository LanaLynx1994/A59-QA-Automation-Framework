package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected Actions actions;
/*
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return threadDriver.get();


    }

 */

    public BasePage (WebDriver givenDriver){
     driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        /*
        threadDriver.set(givenDriver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
*/

    }

    By chooseAllSongs = By.cssSelector("li a.songs");
    By soundBarVisualiser = By.cssSelector("[data-testid='sound-bar-play']");

    public boolean isSongPlaying(){
        return findElement(soundBarVisualiser).isDisplayed();}

    public void navigateToChooseAllSongs() {
        findElement(chooseAllSongs).click();
    }

    public WebElement findElement(By locator){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElementIfClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
