import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
      //  navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay"))); //for firefox
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
        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Play or resume']")));
        //WebElement playBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playBtn.click();
    }

    private void clickPlayNextSong() {
        WebElement playNextSongBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Play next song']")));
        //WebElement playNextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextSongBtn.click();
    }
}
