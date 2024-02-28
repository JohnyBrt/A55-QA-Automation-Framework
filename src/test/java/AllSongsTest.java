import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {
    @Test
    public void playSongWithContextClick() {
        //login
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();
        //chooseAllSongsList;
        chooseAllSongsList();
        //contextClickFirstSong;
        contextClickFirstSong();
        //choosePlay;
        choosePlay();
        //Assertions;
        Assert.assertTrue(isSongPlaying());
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div//img[@alt='Sound bars']")));
        return soundBarVisualizer.isDisplayed();
    }

  public void choosePlay() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li[@class='playback']"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }



}
