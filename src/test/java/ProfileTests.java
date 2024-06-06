import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        changeName(uniqueName);
        String profileName = getProfileName();
        Assert.assertEquals(profileName, uniqueName);


    }

    private String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private void changeName(String name) throws InterruptedException {
        provideCurrentPassword("nTtAZKUq");
        enterNewName(name);
        saveChanges();

    }

    private void saveChanges() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.className("btn-submit"));
        saveButton.click();
        Thread.sleep(2000);
    }

    private void navigateToProfilePage() throws InterruptedException {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        profileName.click();
        Thread.sleep(2000);

    }

    private void enterNewName(String name) throws InterruptedException {
        WebElement newName = driver.findElement(By.id("inputProfileName"));
        newName.clear();
        newName.sendKeys(name);
        Thread.sleep(2000);
    }
    private void provideCurrentPassword(String password) throws InterruptedException {
        WebElement currentPassword = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
        Thread.sleep(2000);
    }
}
