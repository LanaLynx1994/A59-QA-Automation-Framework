//import pages.HomePage;
//import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageFactory.LoginPageFactory;
import pageFactory.HomePageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


  //  @Test
    public void loginEmptyEmailPassword() {
       // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test
    public void registrationNavigation(){
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='registration']")));
        // WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
        String registrationPageUrl = "https://qa.koel.app/registration";
       // String actualUrl = driver.getCurrentUrl();
        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(registrationPageUrl, actualUrl);

    }

    // Happy path - Login Test
    @Test
    public void loginValidEmailPassword(){
/*
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        HomePageFactory homePage = new HomePageFactory(driver);

 */
        LoginPageFactory loginPage = new LoginPageFactory(getDriver());
        HomePageFactory homePage = new HomePageFactory(getDriver());

       // loginPage.provideEmail("sviatlana.rysiavets@testpro.io");
       // loginPage.providePassword("nTtAZKUq");
       // loginPage.clickSubmit(); SHORTER:

       // loginPage.login(); //Using pages package

        //using pageFactory package:
        loginPage.provideEmail("sviatlana.rysiavets@testpro.io").providePassword("nTtAZKUq").clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());

      /* // navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        //Avatar Icon for Actual VS Expected
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());*/
    }

    // Not so happy Path - Negative Test case
   //@Test
    public void loginWithInvalidEmailValidPassword() {

        //Step 1
       // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        //Step 2
        provideEmail("invalid@testpro.io");
        //Step 3
        providePassword("nTtAZKUq");
        //Step 4
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    // Not so Happy path - Login Test
    //@Test
    public void loginWithValidEmailNoPassword() {


        //Step 1
       // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        //Step 2
        provideEmail("sviatlana.rysiavets@testpro.io");
        //Step 3
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest (String email, String password) {
        String expectedURL = "https://qa.koel.app/";

        provideEmail(email);
        providePassword(password);
        clickSubmit();
        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
    }

}
