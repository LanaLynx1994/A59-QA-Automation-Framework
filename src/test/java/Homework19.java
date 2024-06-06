import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        clickPlaylist();
        clickDeletePlaylist();
        confirmDeletePlaylist();
        verifyPlaylistDeleted();
    }

    private void verifyPlaylistDeleted() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Deleted playlist \"A play.\"";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(2000);

    }

    private void confirmDeletePlaylist() throws InterruptedException {
        WebElement okButton = driver.findElement(By.cssSelector("button.ok"));
        okButton.click();
        Thread.sleep(2000);
    }

    private void clickDeletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(2000);
    }

    private void clickPlaylist() throws InterruptedException {
        WebElement choosePlaylist = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        choosePlaylist.click();
        Thread.sleep(2000);
    }
}
