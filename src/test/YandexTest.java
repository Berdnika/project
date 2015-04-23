package test; /**
 * Created with IntelliJ IDEA.
 * User: Anna_Berdnik
 * Date: 3/19/15
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposePage;
import pages.DraftsPage;
import pages.InboxPage;
import pages.LoginPage;

public class YandexTest extends BaseTest {

    private static final String PASSWORD = "testdrive";
    private static final String USERNAME = "webdrtest";

    private static final String MAIL_SUBJECT = "WebDriver Yandex demo";
    private static final String MAIL_BODY = "New email sent via WebDriver.";
    private static final String ADRESEE = "webdrtest@yandex.ru";

    @Test (description = "Logging in")
    public void sendingMail () throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        InboxPage inboxPage=loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(isElementPresent(By.id("nb-1")));
        ComposePage composePage=inboxPage.compose();
        composePage.fillMail(ADRESEE,MAIL_SUBJECT,MAIL_BODY);
        DraftsPage draftsPage=composePage.cancelSending();

        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='b-messages']//a//span[@title='WebDriver Yandex demo']")));

        draftsPage.sendMail();

        Assert.assertTrue(isElementPresent(By.id("nb-1")));

        inboxPage.logOut();
    }

    public boolean isElementPresent(By by) {
        return driver.findElement(by).isDisplayed();
    }


}
