package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageFactory extends BasePageFactory{
    public ProfilePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[data-testid='theme-card-oak']")
    WebElement oakTheme;
    @FindBy(css="[data-testid='theme-card-oak'][class='theme selected']")
    WebElement oakThemeSelected;

    public ProfilePageFactory selectOakTheme(){
        oakTheme.click();
        return this;
    }
    public boolean isOakThemeSelected(){
        return oakThemeSelected.isDisplayed();
    }
}
