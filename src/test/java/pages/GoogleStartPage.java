package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 22-Feb-16.
 */
public class GoogleStartPage {
    private List<WebDriver> driverList = new ArrayList<WebDriver>();
    ResourceBundle rb = ResourceBundle.getBundle("users");
    private static GoogleStartPage instance = new GoogleStartPage();

    private GoogleStartPage() {

    }

    public static GoogleStartPage get() {
        return instance;
    }

    public GoogleSearchPage load() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverList.add(driver);
        driver.get(rb.getString("google"));
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage logout() {
        driverList.get(0).get(rb.getString("google"));
        return new GoogleSearchPage(driverList.get(0));
    }


    public void quit() {
        for (WebDriver driver : driverList) {
            driver.quit();
        }
    }


}

