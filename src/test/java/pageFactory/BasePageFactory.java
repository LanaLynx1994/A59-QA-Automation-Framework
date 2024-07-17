package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return threadDriver.get();
    }



    public BasePageFactory(WebDriver givenDriver){
        /*
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this); //new PageFactory

         */
        threadDriver.set(givenDriver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css="li a.songs")
    WebElement chooseAllSongs;
    @FindBy(css="[data-testid='sound-bar-play']")
    WebElement soundBarVisualiser;
    //By chooseAllSongs = By.cssSelector("li a.songs");
    //By soundBarVisualiser = By.cssSelector("[data-testid='sound-bar-play']");

    public WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement findElementIfClickable(WebElement webElement){
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public BasePageFactory click (WebElement webElement) {
        findElement(webElement).click();
        return this;
    }
    public void doubleClick (WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }
    public void contextClick (WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }

    public boolean isSongPlaying(){
        return soundBarVisualiser.isDisplayed();
    }

    public BasePageFactory navigateToChooseAllSongs() {
        chooseAllSongs.click();
        return this;
    }



}
