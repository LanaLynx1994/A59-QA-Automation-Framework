import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{

    @Test(dependsOnMethods = "CreatePlaylist.createPlaylist")
    public void addSongToPlaylist() {
        //  navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        searchForASong("Dee");
        clickViewAll();
        chooseFirstSearchResult();
        addToPlaylist();
        chooseFirstPlaylist();
        verifySongAdded();
    }

    private void verifySongAdded() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Added 1 song into \"A play.\"";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    private void chooseFirstPlaylist() {
        WebElement addToFirstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        //WebElement addToFirstPlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        addToFirstPlaylist.click();
    }

    private void addToPlaylist() {
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-add-to")));
        // WebElement addToButton = driver.findElement(By.className("btn-add-to"));
        addToButton.click();

    }

    private void chooseFirstSearchResult() {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper .item-container table tr:first-child td.title")));
        // WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper .item-container table tr:first-child td.title"));
        firstSong.click();
    }

    private void clickViewAll() {
        WebElement buttonViewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']")));
        //  WebElement buttonViewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        buttonViewAll.click();
    }

    private void searchForASong(String song) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        // WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    @Test
    public void playSongWithRightClick(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay"))); // for firefox
        basePage.navigateToChooseAllSongs();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayFromContext();
        Assert.assertTrue(basePage.isSongPlaying());
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
