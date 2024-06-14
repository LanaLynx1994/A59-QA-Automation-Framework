package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img[class='avatar']");
    By soundBarVisualiser = By.cssSelector("[data-testid='sound-bar-play']");

public WebElement getUserAvatar(){
    return findElement(userAvatarIcon);
}
public WebElement getSoundBarVisualiser(){return findElement(soundBarVisualiser);}

}
