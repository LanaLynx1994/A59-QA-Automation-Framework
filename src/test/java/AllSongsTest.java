import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{

    @Test
    public void playSongWithRightClick(){
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        //Navigate to All Songs Page
        navigateToChooseAllSongs();
        //Right/Context Click on the first song
        contextClickFirstSong();
        //Choose play from context menu
        choosePlayOption();
        //Verify song is playing
        isSongPlaying();
        Assert.assertTrue(isSongPlaying());

    }

    private boolean isSongPlaying() {
        WebElement soundBarVisualiser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualiser.isDisplayed();
    }

    private void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    private void contextClickFirstSong() {
       WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
       actions.contextClick(firstSongElement).perform();
    }

    private void navigateToChooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
}
