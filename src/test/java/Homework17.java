import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
      //  navigateToPage();
        provideEmail("sviatlana.rysiavets@testpro.io");
        providePassword("nTtAZKUq");
        clickSubmit();
        searchForASong("Dee");
        clickViewAll();
        chooseFirstSearchResult();
        addToPlaylist();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String actualMessage = notification.getText();
        String expectedMessage = "Added 1 song into \"H17.\"";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    private void addToPlaylist() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.className("btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);
        WebElement addToH17Playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        addToH17Playlist.click();
    }

    private void chooseFirstSearchResult() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper .item-container table tr:first-child td.title"));
        firstSong.click();
    }

    private void clickViewAll() {
        WebElement buttonViewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        buttonViewAll.click();
    }

    private void searchForASong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }
}
