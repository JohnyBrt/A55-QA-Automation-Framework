import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedSongAddedSuccessMsg = "Deleted Playlist \"HW19.\"";
        //navigate

        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        //log in
        clickSubmit();
        // click on the playlist
        clickOnPlaylist();

        // click to delete the playlist
        clickToDeletePlaylist();
        Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedSongAddedSuccessMsg );

        Thread.sleep(2000);
    }

    public void clickToDeletePlaylist() {
        WebElement deletePlaylist = driver.findElement(By.xpath("//div/span/button[ @title= 'Delete this playlist']"));
    }

    public void clickOnPlaylist() {
        WebElement clickPlaylist = driver.findElement(By.xpath("//li[ @class='playlist playlist']/a"));
        clickPlaylist.click();
    }

    public String getDeletedPlaylistMsg() {
        WebElement notification = driver.findElement(By.xpath("//div[ @class='success show']"));
        return notification.getText();

    }
}