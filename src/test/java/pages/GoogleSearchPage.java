package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 19-Feb-16.
 */
public class GoogleSearchPage {
    private WebDriver driver;
    private WebElement searchField;
    private WebElement submitButton;
    private WebElement postBoxLink;
    private List<WebElement> content;
    private static final Logger log = Logger.getLogger(ResultPage.class);

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        searchField = driver.findElement(By.id("lst-ib"));
        submitButton = driver.findElement(By.cssSelector("[name*='btnG']"));
        postBoxLink = driver.findElement(By.cssSelector("[class*='gb_P']"));
        content = driver.findElements(By.cssSelector("h3.r"));
    }

    // Get Elements

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getPostBoxLink() {
        return postBoxLink;
    }


    // Set Data

    public void setSearchField(String word) {
        searchField.sendKeys(word);
    }

    public void clearSearchField() {
        searchField.clear();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public GoogleLoginPage clickPostBoxLink() {
        postBoxLink.click();
        return new GoogleLoginPage(driver);
    }

    public GoogleSearchPage clickSubmitButton() {
        submitButton.click();
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage setSearchData(String word) {
        clickSearchField();
        clearSearchField();
        setSearchField(word);
        return new GoogleSearchPage(driver);
    }

    public List parseResultPage() {
        List<String> links = new ArrayList<String>();
        for (WebElement doc : content) {
            if (content.size() >= 5) {
                links.add(doc.getText());
                log.info(doc.getText());
                //System.out.println(doc.getText());
            }
        }
        return links;
    }

}
