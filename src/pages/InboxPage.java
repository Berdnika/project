package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Anna_Berdnik
 * Date: 4/15/15
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */

public class InboxPage extends BasePage{
    @FindBy (xpath = "//a/span[text()='Compose']")
    protected WebElement composeButton;

    @FindBy (id = "nb-1")
    private WebElement userLogo;

    @FindBy (xpath = "//div[@class='b-mail-dropdown__item']//a[text()='Log out']")
    private WebElement logoutButton;

    public InboxPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComposePage compose(){
        composeButton.click();
        return new ComposePage(driver);
    }

    public void logOut(){
        userLogo.click();
        logoutButton.click();
    }

}
