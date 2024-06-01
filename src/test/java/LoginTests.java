import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    // Happy path - Login Test
    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //Step 1
        navigateToPage();
        //Step 2
        provideEmail("sviatlana.rysiavets@testpro.io");
        //Step 3
        providePassword("nTtAZKUq");
        Thread.sleep(2000);
        //Step 4
        clickSubmit();
        Thread.sleep(4000);
        //Avatar Icon for Actual VS Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    // Not so happy Path - Negative Test case
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //Step 1
        navigateToPage();
        //Step 2
        provideEmail("invalid@testpro.io");
        //Step 3
        providePassword("nTtAZKUq");
        //Step 4
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    // Not so Happy path - Login Test
    @Test
    public void loginWithValidEmailNoPassword() throws InterruptedException {


        //Step 1
        navigateToPage();
        //Step 2
        provideEmail("sviatlana.rysiavets@testpro.io");
        //Step 3
        clickSubmit();
        //Expected result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}


