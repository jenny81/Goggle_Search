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
public class StartPage {
    private List<WebDriver> driverList = new ArrayList<WebDriver>();
    ResourceBundle rb = ResourceBundle.getBundle("users");
    private static StartPage instance = new StartPage();

    private StartPage() {

    }

    public static StartPage get() {
        return instance;
    }

    public SearchPage load() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverList.add(driver);
        driver.get(rb.getString("url"));
        return new SearchPage(driver);
    }

    public SearchPage logout() {
        driverList.get(0).get(rb.getString("url"));
        return new SearchPage(driverList.get(0));
    }


    public void quit() {
        for (WebDriver driver : driverList) {
            driver.quit();
        }
    }

}

