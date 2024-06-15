package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
   // By emailField = By.cssSelector("input[type='email']");
   // By passwordField =By.cssSelector("input[type='password']");
  //  By submitBtn = By.cssSelector("button[type='submit']");

    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css ="button[type='submit']" )
    WebElement submitBtn;



    //Page Methods
    public LoginPage provideEmail(String email){

        emailField.sendKeys(email);
        return this;
        //findElement(emailField).sendKeys(email);
    }
    public LoginPage providePassword(String password){

        passwordField.sendKeys(password);
        return this;

        //findElement(passwordField).sendKeys(password);
    }
    public LoginPage clickSubmit(){

        submitBtn.click();
        return this;
        //findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
    }
}
