package pages;

import data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 20-Feb-16.
 */
public class GooglePasswordPage {
    private WebDriver driver;
    private WebElement passwordField;
    private WebElement signInButton;

    public GooglePasswordPage(WebDriver driver) {
        this.driver = driver;
        passwordField = driver.findElement(By.id("Passwd"));
        signInButton = driver.findElement(By.id("signIn"));
    }
    // Get Elements

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignIn() {
        return signInButton;
    }

    // Set Data
    public void setPasswordField(String searchText) {
        passwordField.sendKeys(searchText);
    }

    public void clearPasswordField() {
        passwordField.clear();
    }

    public void clickPasswordField() {
        passwordField.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public GoogleEmailPage setPassword(User user) {
        clickPasswordField();
        clearPasswordField();
        setPasswordField(user.getPassword());
        clickSignInButton();
        return new GoogleEmailPage(driver);
    }
}
