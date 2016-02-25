package tests;

import data.User;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.ResultPage;
import pages.StartPage;

import java.util.List;

/**
 * Created by Admin on 19-Feb-16.
 */
public class TestSearch {
    //private WebDriver driver;

    @AfterMethod
//    public void tearDown() {
//        StartPage.get().logout();
//    }

    @AfterClass
    //public void oneTimeTearDown() {
//        StartPage.get().quit();
//    }

    @DataProvider
    public Object[][] word() {
        return new Object[][]{new Object[]{"dog"}};
    }

    @Test(priority = 1, dataProvider = "word")
    public void testSearchWords(String word) throws Exception {
        ResultPage resultPage = StartPage.get().load().setSearchData(word);
        resultPage = resultPage.clickSubmitButton();
        // create list of found items
        List dataFromPage = resultPage.parseResultPage();
        Assert.assertTrue(dataFromPage.size()>=5);
    }

    @DataProvider
    public Object[][] validUser() {
        return new Object[][]{
                {UserRepository.get().getValidUser()}
        };
    }

    @Test(priority = 2, dataProvider = "validUser")
    public void testSearchOfLetters(User validUser) throws Exception {
        EmailPage emailPage = StartPage.get().load().clickPostBoxLink().setEmail(UserRepository.get().getValidUser())
                .setPassword(UserRepository.get().getValidUser());
        List dataFromEmailPage = emailPage.parseEmailPage();
        Assert.assertTrue(dataFromEmailPage.size()>=5);
    }

}


