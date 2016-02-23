package pages;

import data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 20-Feb-16.
 */
public class PasswordPage {
    private WebDriver driver;
    private WebElement passwordField;
    private WebElement signInButton;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        this.passwordField = driver.findElement(By.id("Passwd"));
        this.signInButton = driver.findElement(By.id("signIn"));
    }
    // Get Elements

    public WebElement getPasswordield() {
        return this.passwordField;
    }

    public WebElement getSignIn() {
        return this.signInButton;
    }

    // Set Data
    public void setPasswordield(String searchText) {
        this.passwordField.sendKeys(searchText);
    }

    public void clearPasswordield() {
        this.passwordField.clear();
    }

    public void clickPasswordield() {
        this.passwordField.click();
    }

    public void clickSignInButton() {
        this.signInButton.click();
    }

    public EmailPage setPassword(IUser user) {
        clickPasswordield();
        clearPasswordield();
        setPasswordield(user.getPassword());
        clickSignInButton();
        return new EmailPage(driver);
    }
}
