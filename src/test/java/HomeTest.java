import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        //  navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay"))); //for firefox
        clickPlayNextSong();
        clickPlayBtn();
        validateSongIsPlaying();

    }

    private void validateSongIsPlaying() {
        WebElement pauseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Pause']")));
        // WebElement pauseBtn = driver.findElement(By.cssSelector("[title='Pause']"));
        pauseBtn.isDisplayed();
    }

    private void clickPlayBtn() {
        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play or resume']")));
        //WebElement playBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playBtn.click();
    }

    private void clickPlayNextSong() {
        WebElement playNextSongBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Play next song']")));
        //WebElement playNextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextSongBtn.click();
    }


    @Test
    public void HoverOverPlayButtonAndPlaySong(){
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    @Test
    public void countSongsInPlaylist(){
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay"))); //for firefox
        //Choose a Playlist by name
        choosePlaylistByName("TestPro playlist");
        //DisplayAllSongs
        displayAllSongs();
        //Number of songs are equal to number of songs displayed in the info screen
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(songsCount())));
        //String 1 (getPlaylistDetails())  = 4 songs • 17:16 • Download All
        //String 2 (songsCount()) = 4
        //Assert returns String 1.contains(String 2)
    }



    //Helper Methods


    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public int songsCount(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+songsCount());
        for (WebElement e : songList){
            System.out.println(e.getText());
        }
    }

    private void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }

    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    @Test(dependsOnMethods = "HomeTest.renamePlaylist")
    public void deletePlaylist() {
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay"))); //for firefox
        clickPlaylist();
        clickDeletePlaylist();
        confirmDeletePlaylist();
        verifyPlaylistDeleted();
    }

    private void verifyPlaylistDeleted() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Deleted playlist \"B play.\"";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    private void confirmDeletePlaylist(){
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        // WebElement okButton = driver.findElement(By.cssSelector("button.ok"));
        okButton.click();
    }

    private void clickDeletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylistButton.click();
    }

    private void clickPlaylist(){
        WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists li:nth-child(3)")));
        choosePlaylist.click();
    }

    String newPlaylistName = "B play";
    @Test(dependsOnMethods = "AllSongsTest.addSongToPlaylist")
    public void renamePlaylist() {
        String updatedPlaylistMessage = "Updated playlist \"B play.\"";

        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        doubleClickPlaylist();
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
