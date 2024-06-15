package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this); //new PageFactory
    }

    By chooseAllSongs = By.cssSelector("li a.songs");
    By soundBarVisualiser = By.cssSelector("[data-testid='sound-bar-play']");

    public WebElement getSoundBarVisualiser(){return findElement(soundBarVisualiser);}

    public void navigateToChooseAllSongs() {
        findElement(chooseAllSongs).click();
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElementIfClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
