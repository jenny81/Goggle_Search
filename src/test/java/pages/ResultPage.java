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
public class ResultPage {
    private WebDriver driver;
    private WebElement submitButton;
    private WebElement searchField;
    private List<WebElement> content;
    private static final Logger log = Logger.getLogger(ResultPage.class);


    public ResultPage(WebDriver driver) {
        this.driver = driver;
        submitButton = driver.findElement(By.cssSelector("[name*='btnG']"));
        searchField = driver.findElement(By.id("lst-ib"));
        content = driver.findElements(By.cssSelector("h3.r"));

    }

    // Get Elements
    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getSearchField() {
        return searchField;
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

    public ResultPage clickSubmitButton() {
        submitButton.click();
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
                links.add(doc.getText());
                log.info(doc.getText());
                //System.out.println(doc.getText());
            }
        }
        return links;
    }
}
