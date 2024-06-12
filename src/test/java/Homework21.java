import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String newPlaylistName = "B play";
    @Test(dependsOnMethods = "Homework17.addSongToPlaylist")
    public void renamePlaylist() {
        String updatedPlaylistMessage = "Updated playlist \"B play.\"";

        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        //double click on playlist name
        doubleClickPlaylist();
        //enter new Name
        enterNewName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMessage);

    }

    //Helper Methods
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear() does not work, element has an attribute of 'required'
        //workaround is Ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void doubleClickPlaylist(){
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }

}
