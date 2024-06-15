import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{

    @Test
    public void playSongWithRightClick(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        basePage.navigateToChooseAllSongs();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayFromContext();
        Assert.assertTrue(basePage.getSoundBarVisualiser().isDisplayed());
//        isSongPlaying();
//        Assert.assertTrue(isSongPlaying());


    }



       // provideEmail("sviatlana.rysiavets@testpro.io");
       // providePassword("nTtAZKUq");
       // clickSubmit();
        //Navigate to All Songs Page
       // navigateToChooseAllSongs();
        //Right/Context Click on the first song
        //contextClickFirstSong();
        //Choose play from context menu
        //choosePlayOption();
        //Verify song is playing


//   private boolean isSongPlaying() {
//
//        WebElement soundBarVisualiser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
//        return soundBarVisualiser.isDisplayed();
  //  }
//
//    private void choosePlayOption() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
//    }

//    private void contextClickFirstSong() {
//       WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//       actions.contextClick(firstSongElement).perform();
//    }

   // private void navigateToChooseAllSongs() {
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

   // }
}
