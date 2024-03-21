package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    String newPlaylistName1 = "Test22";
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements
    By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("name='name'");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By allSongsList = By.xpath("//a[@class='songs']");
    //Helper Method

    public WebElement getUserAvatar(){

        return findElement(userAvatarIcon);
    }
public void doubleClickPlaylist(){
        doubleClick(firstPlaylist);
}
public void enterNewName(String playlistName ){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
}
 public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();

 }
    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }
}
