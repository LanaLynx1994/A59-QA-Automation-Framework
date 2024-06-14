package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    By chooseAllSongs = By.cssSelector("li a.songs");
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By contextPlay = By.cssSelector("li.playback");

    public void navigateToChooseAllSongs(){
        findElement(chooseAllSongs).click();
    }
    public void contextClickFirstSong(){
        WebElement firstSongElement = findElement(firstSong);
        actions.contextClick(firstSongElement).perform();
    }
    public void contextPlayOption(){
        findElement(contextPlay).click();
    }

}
