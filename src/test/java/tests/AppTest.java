package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;


    //@Test(priority = 1)
    public void testSearchOfWords() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // find item
        driver.get("https://www.google.com.ua/?gws_rd=ssl");
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("doc");
        driver.findElement(By.cssSelector("[name*='btnG']")).click();
        // create list of found items
        List<WebElement> docs = driver.findElements(By.partialLinkText("doc"));
        List<String> links = new ArrayList<>();
        for (WebElement doc : docs) {
            if (docs.size() >= 5) {
                links.add(doc.getAttribute("href"));
                System.out.println(doc.getAttribute("href"));
                System.out.println(doc.getText().toLowerCase());

            }


        }
    }

   // @Test(priority = 2)
    public void testSearchOfLetters() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/?gws_rd=ssl");
        driver.findElement(By.cssSelector("[class*='gb_P']")).click();
        driver.findElement(By.id("Email")).sendKeys("jenny.yud81@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("8bv4gf2tr");
        driver.findElement(By.id("signIn")).click();

        //(
//
        List<WebElement> docs = driver.findElements(By.cssSelector("[class*='yX xY ']"));
        List<String> letters = new ArrayList<>();
        for (WebElement doc : docs) {
            if (docs.size() >= 5) {
                letters.add(doc.getText());
                //System.out.println(doc.getAttribute("value"));
                System.out.println(doc.getText());

                //Assert.assertEquals("Увійти", driver.findElement(By.linkText("Увійти")).getText());
            }
            System.out.println(letters);

        }}}


