package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 19-Feb-16.
 */
public class SearchPage {
    private WebDriver driver;
    private WebElement searchField;
    private WebElement postBoxLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.searchField = driver.findElement(By.id("lst-ib"));
        this.postBoxLink = driver.findElement(By.cssSelector("[class*='gb_P']"));
    }

    // Get Elements

    public WebElement getSearchField() {
        return this.searchField;
    }

    public WebElement getPostBoxLink() {
        return this.postBoxLink;
    }


    // Set Data

    public void setSearchField(String word) {
        this.searchField.sendKeys(word);
    }

    public void clearSearchField() {
        this.searchField.clear();
    }

    public void clickSearchField() {
        this.searchField.click();
    }

    public LoginPage clickPostBoxLink() {
        this.postBoxLink.click();
        return new LoginPage(driver);
    }

    // Business Logic

    public ResultPage setSearchData(String word) {
        clickSearchField();
        clearSearchField();
        setSearchField(word);
        return new ResultPage(driver);
    }

}
