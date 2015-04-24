package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: Anna_Berdnik
 * Date: 4/15/15
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */

public class DraftsPage extends BasePage {

    @FindBy (xpath="//div[@class='b-messages']//a//span[@title='WebDriver Yandex demo']")
    protected WebElement draftTitle;

    @FindBy (xpath="//button[span[span[text()='Send']]]")
    protected WebElement sendButton;

    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendMail(){
        draftTitle.click();
        sendButton.click();
    }

}
