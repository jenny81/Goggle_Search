package pages;

import data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 19-Feb-16.
 */
public class LoginPage {
    private WebDriver driver;
    private WebElement emailField;
    private WebElement nextButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.emailField = driver.findElement(By.id("Email"));
        this.nextButton = driver.findElement(By.id("next"));
    }
    // Get Elements

    public WebElement getEmailField() {
        return this.emailField;
    }

    public WebElement getNextButton() {
        return this.nextButton;
    }

    // Set Data
    public void setEmailField(String searchText) {
        this.emailField.sendKeys(searchText);
    }

    public void clearEmailField() {
        this.emailField.clear();
    }

    public void clickEmailField() {
        this.emailField.click();
    }

    public void clickNextButton() {
        this.nextButton.click();
        //return new PasswordPage(driver);
    }
    public PasswordPage setEmail(IUser user) {
        clickEmailField();
        clearEmailField();
        setEmailField(user.getEmail());
        clickNextButton();
        return new PasswordPage(driver);
    }

}
