import pages.HomePage;
//import pages.LoginPage;
import pageFactory.LoginPage;
import pageFactory.BasePage;
//import pageFactory.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
  //  @Test
    public void loginEmptyEmailPassword() {
       // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    // Happy path - Login Test
    @Test
    public void loginValidEmailPassword(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       // loginPage.provideEmail("sviatlana.rysiavets@testpro.io");
       // loginPage.providePassword("nTtAZKUq");
       // loginPage.clickSubmit(); SHORTER:

       // loginPage.login(); //Using pages package

        //using pageFactory package:
        loginPage.provideEmail("sviatlana.rysiavets@testpro.io").providePassword("nTtAZKUq").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

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
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

}
