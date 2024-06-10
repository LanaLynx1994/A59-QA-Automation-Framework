import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileName() throws InterruptedException {
        //navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        Thread.sleep(2000); // cannot remove - test fails
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        Thread.sleep(2000); // cannot remove - test fails
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);


    }

    private String getProfileName() {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
       // WebElement profileName = driver.findElement(By.cssSelector("span.name"));
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
       // WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("btn-submit")));
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
    }

    private void navigateToProfilePage() {
        WebElement profileName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.name")));
        //WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        profileName.click();

    }

    private void enterNewName(String name)  {
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileName")));
        //WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
    }
    private void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileCurrentPassword")));
        //WebElement currentPassword = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
}
