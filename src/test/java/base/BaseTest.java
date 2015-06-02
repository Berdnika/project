package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.java.base.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created with IntelliJ IDEA.
 * User: Anna_Berdnik
 * Date: 4/22/15
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest {

    protected static final String MAIL_URL = "https://mail.yandex.com/";
    protected WebDriver driver;

    @BeforeClass(description = "WebDriver initialize")
    public void initBrowser () throws IOException {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(MAIL_URL);
        Logger.debug("Navigation to mail " + MAIL_URL);
        takeScreenshot();
    }

    @AfterClass(description = "Close FireFox")
    public void stopBrowser() throws IOException {
        Logger.debug("Quit FF");
        takeScreenshot();
        driver.quit();
    }

    public void takeScreenshot() throws IOException {
        SimpleDateFormat dt = new SimpleDateFormat("hh-mm-ss");
        Date date = new Date();
        String uniqueName = dt.format(date);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(".//output//screen"+uniqueName+".jpg"));

    }

}

