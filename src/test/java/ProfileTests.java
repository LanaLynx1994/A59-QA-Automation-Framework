import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.LoginPageFactory;
import pageFactory.ProfilePageFactory;

import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test
    public void ChangeThemeToOak(){

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver);

        loginPageFactory.login();
        wait.until(ExpectedConditions.urlContains(".app/#!/home"));
        driver.get("https://qa.koel.app/#!/profile");
        driver.navigate().refresh();
        profilePageFactory.selectOakTheme();
        Assert.assertTrue(profilePageFactory.isOakThemeSelected());
        
    }
    @Test
    public void changeProfileName() {
        //navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        wait.until(ExpectedConditions.urlContains(".app/#!/home"));
        driver.get("https://qa.koel.app/#!/profile");
        driver.navigate().refresh();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);


    }

    private String getProfileName() {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private void changeName(String name) {
        provideCurrentPassword("nTtAZKUq");
        enterNewName(name);
        saveChanges();

    }

    private void saveChanges()  {
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void enterNewName(String name)  {
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileName")));
        newName.clear();
        newName.sendKeys(name);
    }
    private void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileCurrentPassword")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
}
