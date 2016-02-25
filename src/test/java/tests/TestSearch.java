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

    @DataProvider
    public Object[][] word() {
        return new Object[][]{new Object[]{"dog"}};
    }

    @DataProvider
    public Object[][] validUser() {
        return new Object[][]{
                {UserRepository.get().getValidUser()}
        };
    }

    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        StartPage.get().quit();
    }

    @Test(priority = 1, dataProvider = "word")
    public void testSearchWords(String word) throws Exception {
        //Test steps
        ResultPage resultPage = StartPage.get().load().setSearchData(word);
        resultPage = resultPage.clickSubmitButton();
        // Creating list of found items
        List dataFromPage = resultPage.parseResultPage();
        //Checking
        Assert.assertTrue(dataFromPage.size() >= 5);
    }


    @Test(priority = 2, dataProvider = "validUser")
    public void testSearchOfLetters(User validUser) throws Exception {
        //Test steps
        EmailPage emailPage = StartPage.get().load().clickPostBoxLink().setEmail(UserRepository.get().getValidUser())
                .setPassword(UserRepository.get().getValidUser());
        // Creating list of found items
        List dataFromEmailPage = emailPage.parseEmailPage();
        //Checking
        Assert.assertTrue(dataFromEmailPage.size() >= 5);
    }

}


