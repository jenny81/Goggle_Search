package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20-Feb-16.
 */
public class GoogleEmailPage {
    private WebDriver driver;
    private static final Logger log = Logger.getLogger(GoogleEmailPage.class);
    private List<WebElement> content;

    public GoogleEmailPage(WebDriver driver) {
        this.driver = driver;
        content = driver.findElements(By.cssSelector("[class*='yX xY ']"));

    }

    public List parseEmailPage() {
        List<String> letters = new ArrayList<String>();
        for (WebElement doc : content) {
            if (content.size() >= 5) {
                letters.add(doc.getText());
                log.info(doc.getText());
                //System.out.println(doc.getText());
            }
        }
        return letters;
    }
}
