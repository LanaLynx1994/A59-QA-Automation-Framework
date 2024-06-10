import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20aka19 extends BaseTest{
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

    private void verifyPlaylistDeleted() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Deleted playlist \"A play.\"";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    private void confirmDeletePlaylist(){
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
       // WebElement okButton = driver.findElement(By.cssSelector("button.ok"));
        okButton.click();
    }

    private void clickDeletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
       // WebElement deletePlaylistButton = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistButton.click();
    }

    private void clickPlaylist(){
        WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists li:nth-child(3)")));
        //WebElement choosePlaylist = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        choosePlaylist.click();
    }
}
