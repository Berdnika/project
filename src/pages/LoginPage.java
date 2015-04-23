package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Anna_Berdnik
 * Date: 4/15/15
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */

public class LoginPage extends BasePage {
    @FindBy(name="login")
    private WebElement userNameField;

    @FindBy(name="passwd")
    private WebElement passwordField;

    @FindBy(xpath="//button/span[text()='Log in']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   public InboxPage login(String login, String password){
       userNameField.sendKeys(login);
       passwordField.sendKeys(password);
       loginButton.click();
       return new InboxPage(driver);
   }

}
