import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    //addSongToPlaylist
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedSuccessMsq = "Added 1 song into \"test.\"";


        //navigate to koel
        navigateToPage();
        // login with valid credentials
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();


        //search for a song
        searchForSong("Episode 2");
        Thread.sleep(5000);

        //click "View All" button
        viewAllButton();
        Thread.sleep(5000);

        //click on the song
        clickOnTheSong();
        Thread.sleep(5000);

        //click on "ADD TO'
        clickAddTo();
        Thread.sleep(5000);


        //Choose the playlist
        choosePlaylist();
        Thread.sleep(5000);

        //Assertions
        Assert.assertEquals(getSongAddedSuccessMsg(), expectedSongAddedSuccessMsq);
        Thread.sleep(5000);
    }

    public void searchForSong(String songName) {
        WebElement searchTab = driver.findElement(By.cssSelector("input[type='search']"));
        searchTab.clear();
        searchTab.sendKeys(songName);

    }
    public void viewAllButton() {
        WebElement viewAll = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAll.click();
    }
    public void clickOnTheSong() {
        WebElement clickSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        clickSong.click();
    }


    public void clickAddTo() {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
    }
    public void choosePlaylist() {
        WebElement choosePlst = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        choosePlst.click();
    }

    public String getSongAddedSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }
}
