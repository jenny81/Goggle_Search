package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 20-Feb-16.
 */
public class PasswordPage {
    private WebDriver driver;
    private WebElement passwordField;
    private WebElement signIn;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        this.passwordField = driver.findElement(By.id("Passwd"));
        this.signIn = driver.findElement(By.id("signIn"));
    }
    // Get Elements

    public WebElement getPasswordield() {
        return this.passwordField;
    }

    public WebElement getSignIn() {
        return this.signIn;
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

    public void clickSignIn() {
        this.signIn.click();
    }

    public EmailPage setPassword(IUser user) {
        clickPasswordield();
        clearPasswordield();
        setPasswordield(user.getPassword());
        clickSignIn();
        return new EmailPage(driver);
    }
}
