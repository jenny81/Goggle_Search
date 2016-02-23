package search;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

/**
 * Created by Admin on 19-Feb-16.
 */
public class TestSearchWord {
    //private WebDriver driver;

    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        StartPage.get().quit();
    }

    @DataProvider
    public Object[][] word() {
        return new Object[][]{new Object[]{"doc"},};
    }

    @Test(priority = 1, dataProvider = "word")
    public void testSearchWords(String word) throws Exception {
        ResultPage resultPage = StartPage.get().load().setSearchData(word);
        resultPage = resultPage.clickSubmit();
        // create list of found items
        List dataFromPage = resultPage.parseResultPage();
        System.out.println(dataFromPage);

    }

    @DataProvider
    public Object[][] validUser() {
        return new Object[][]{
                {UserRepository.get().getValidUser()},
        };
    }

    @Test(priority = 2, dataProvider = "validUser")
    public void testSearchOfLetters(IUser validUser) throws Exception {
        EmailPage emailPage = StartPage.get().load().clickGmail().setEmail(UserRepository.get().getValidUser()).setPassword(UserRepository.get().getValidUser());
        List dataFromEmailPage = emailPage.parseEmailPage();
        System.out.println(dataFromEmailPage);

    }

}


