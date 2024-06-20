package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory extends BasePageFactory {

    public HomePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css="img[class='avatar']")
    WebElement userAvatarIcon;
   // By userAvatarIcon = By.cssSelector("img[class='avatar']");


    public boolean isAvatarDisplayed(){

        return userAvatarIcon.isDisplayed();

    }
}
