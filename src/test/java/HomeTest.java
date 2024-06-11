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
}
