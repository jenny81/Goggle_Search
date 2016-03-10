package tests;

import data.User;
import data.UserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

/**
 * Created by Admin on 19-Feb-16.
 */
public class TestSearch {
    //private WebDriver driver;

    @DataProvider
    public Object[][] word() {
        return new Object[][]{new Object[]{"dog"} };
    }

    @DataProvider
    public Object[][] validGoogleUser() {
        return new Object[][]{
                {UserRepository.get().getValidGoogleUser()}
        };
    }

    @DataProvider
    public Object[][] validYahooUser() {
        return new Object[][]{
                {UserRepository.get().getValidYahooUser()}
        };
    }

    @DataProvider
    public Object[][] validRamblerUser() {
        return new Object[][]{
                {UserRepository.get().getValidRamblerUser()}
        };
    }
    //@AfterMethod
//    public void tearDown() {
//        GoogleStartPage.get().logout();
//    }

    //@AfterClass
//    public void oneTimeTearDown() {
//        GoogleStartPage.get().quit();
//    }

    @Test(priority = 1, dataProvider = "word")
    public void testSearchWords(String word) throws Exception {
        //Test steps
        GoogleSearchPage googleSearchPage = GoogleStartPage.get().load().setSearchData(word).clickSubmitButton();
        // Creating list of found items
        List dataFromPageList = googleSearchPage.parseResultPage();
        //Checking
        Assert.assertTrue(dataFromPageList.size() >= 5);
    }


    @Test(priority = 2, dataProvider = "validGoogleUser")
    public void testGetGoogleEmailsList(User validGoogleUser) throws Exception {
        //Preconditions
       GoogleEmailPage googleEmailPage = GoogleStartPage.get().load().clickPostBoxLink().setEmail(validGoogleUser)
                .setPassword(validGoogleUser);
        //Test steps
        List EmailsList = googleEmailPage.parseEmailPage();
        //Checking
        Assert.assertTrue(EmailsList.size() >= 5);
    }

    @Test(priority = 3, dataProvider = "validYahooUser")
    public void testGetYahooEmailsList(User validYahooUser) throws Exception {
        //Preconditions
//        YahooEmailPage yahooEmailPage = YahooStartPage.get().load().clickPostBoxLink().setEmail(validYahooUser)
//                .setPassword(validYahooUser);
        YahooPasswordPage yahooPasswordPage = YahooStartPage.get().load().clickPostBoxLink().setEmail(validYahooUser);
        Thread.sleep(1000);
        YahooEmailPage yahooEmailPage = yahooPasswordPage.setPassword(validYahooUser);
        //YahooEmailPage yahooEmailPage = yahooPasswordPage.clearPasswordField().clearPasswordField().setPasswordField(validYahooUser).clickSignInButton();
        //Test steps
        List EmailsList = yahooEmailPage.parseEmailPage();
        //Checking
        Assert.assertTrue(EmailsList.size() >= 5);
        //YahooStartPage.get().logout();
        YahooStartPage.get().quit();
    }

    @Test(priority = 4, dataProvider = "validRamblerUser")
    public void testGetRamblerEmailsList(User validRamblerUser) throws Exception {
        //Preconditions
        RamblerEmailPage ramblerEmailPage = RamblerStartPage.get().load().clickPostBoxLink().setUserData(validRamblerUser);
        //Test steps
        List EmailsList = ramblerEmailPage.parseEmailPage();
        //Checking
        Assert.assertTrue(EmailsList.size() >= 5);
    }
}


