import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePlaylist extends BaseTest{
    @Test
    public void createPlaylist(){
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        clickCreateNewPlaylist();
        chooseNewPlaylist();
        enterPlaylistName("A play");
        verifyPlaylistAdded();

    }

    private void verifyPlaylistAdded() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Created playlist \"A play.\"";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    private void enterPlaylistName(String playlist) {
        WebElement newPlaylistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/form/input")));
        newPlaylistInput.clear();
        newPlaylistInput.sendKeys(playlist);
        newPlaylistInput.sendKeys(Keys.ENTER);
    }

    private void chooseNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        newPlaylist.click();
    }

    private void clickCreateNewPlaylist() {
        WebElement createPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Create a new playlist']")));
        createPlaylistBtn.click();
    }
}
