package pages;

import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 19-Feb-16.
 */
public class GoogleLoginPage {
    private WebDriver driver;
    private WebElement emailField;
    private WebElement nextButton;

    public GoogleLoginPage(WebDriver driver) {
        this.driver = driver;
        emailField = driver.findElement(By.id("Email"));
        nextButton = driver.findElement(By.id("next"));
    }
    // Get Elements

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    // Set Data
    public void setEmailField(String searchText) {
        emailField.sendKeys(searchText);
    }

    public void clearEmailField() {
        emailField.clear();
    }

    public void clickEmailField() {
        emailField.click();
    }

    public void clickNextButton() {
        nextButton.click();
        //return new GooglePasswordPage(driver);
    }

    public GooglePasswordPage setEmail(User user) {
        clickEmailField();
        clearEmailField();
        setEmailField(user.getEmail());
        clickNextButton();
        return new GooglePasswordPage(driver);
    }

}
