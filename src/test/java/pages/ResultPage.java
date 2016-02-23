package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 19-Feb-16.
 */
public class ResultPage {
    private WebDriver driver;
    private WebElement submit;
    private WebElement searchField;
    private List<WebElement> content;


    public ResultPage(WebDriver driver) {
        this.driver = driver;
        this.submit = driver.findElement(By.cssSelector("[name*='btnG']"));
        this.searchField = driver.findElement(By.id("lst-ib"));
        content = driver.findElements(By.partialLinkText("doc"));

    }

    // Get Elements
    public WebElement getSubmit() {
        return this.submit;
    }

    public WebElement getSearchField() {
        return this.searchField;
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

    public ResultPage clickSubmit() {
        this.submit.click();
        return new ResultPage(driver);
    }

    public ResultPage setSearchData(String word) {
        clickSearchField();
        clearSearchField();
        setSearchField(word);
        return new ResultPage(driver);
    }
    public List parseResultPage (){
        List<String> links = new ArrayList<String>();
        for (WebElement doc : content) {
            if (content.size() >= 5) {
                links.add(doc.getAttribute("href"));
                System.out.println(doc.getAttribute("href"));
                System.out.println(doc.getText().toLowerCase());
            }
        }
        return links;
    }
}
