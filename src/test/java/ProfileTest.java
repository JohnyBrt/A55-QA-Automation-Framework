import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{
    @Test
public void changeProfileName() throws InterruptedException {
    // navigate to page
    navigateToPage();
    // login with correct credentials
    provideEmail("ionut.burtoiu@testpro.io");
    providePassword("Luca@20222");
    clickSubmit();
    Thread.sleep(2000);
    // click on avatar icon
    clickAvatarIcon();
        Thread.sleep(2000);
    // create username
    String randomName = generateRandomName();

    // provide current password
    provideCurrentPassword("Luca@20222");
        Thread.sleep(2000);

    // provide new profile name
    provideProfileName(randomName);
        Thread.sleep(2000);
    // click on save
    clickSave();
        Thread.sleep(5000);

    //assertion expected vs actual res
    WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
     Assert.assertEquals(actualProfileName.getText(),randomName);
}

    public void clickSave() {
    WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
    saveButton.click();

    }

    public void provideProfileName(String newName) {
    WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
    profileNameField.clear();
    profileNameField.sendKeys(newName);
    }

    public void provideCurrentPassword(String  currentPassword) {
    WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password'"));
    currentPasswordField.clear();
    currentPasswordField.sendKeys(currentPassword);
    }

    public String generateRandomName() {
    return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon() {
     WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
     avatarIcon.click();
    }
}
