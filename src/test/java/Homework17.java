import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
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
}
