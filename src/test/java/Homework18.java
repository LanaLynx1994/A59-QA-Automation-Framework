import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        clickPlayNextSong();
        clickPlayBtn();
        validateSongIsPlaying();

    }

    private void validateSongIsPlaying() throws InterruptedException {
        WebElement pauseBtn = driver.findElement(By.cssSelector("[title='Pause']"));
        pauseBtn.isDisplayed();
        Thread.sleep(2000);
    }

    private void clickPlayBtn() throws InterruptedException {
        WebElement playBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playBtn.click();
        Thread.sleep(2000);
    }

    private void clickPlayNextSong() throws InterruptedException {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextSongBtn.click();
        Thread.sleep(2000);
    }
}
