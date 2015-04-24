package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
    public void initBrowser (){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(MAIL_URL);
    }

    @AfterClass(description = "Close FireFox")
    public void stopBrowser(){
        System.out.println("quit FF");
        driver.quit();
    }

}

