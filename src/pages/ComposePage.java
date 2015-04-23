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
 * Date: 4/22/15
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComposePage extends BasePage {
    @FindBy(name="subj")
    private WebElement subjectField;

    @FindBy (id="compose-send")
    private WebElement mailBody;

    @FindBy (xpath="//button[span[span[text()='Cancel']]]")
    private WebElement cancelButton;

    @FindBy (xpath = "//button[span[text()='Save and go']]")
    private WebElement goButton;

    @FindBy (xpath="//div[@class='b-folders__i']//a[@title='Drafts']")
    protected WebElement mailDraft;


    public void fillMail(String adresse,String subj,String body){
        new WebDriverWait(driver, 15).until(
        ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'mail-input_to')]/input[contains(@class, 'focus')]")));
        WebElement toField = driver.findElement(By.xpath("//div[contains(@class, 'mail-input_to')]/input[contains(@class, 'focus')]"));
        System.out.println("before - " + toField.getAttribute("disabled"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled');", toField);
        System.out.println("after - " + toField.getAttribute("disabled"));
        toField.sendKeys(adresse);
        subjectField.sendKeys(subj);
        mailBody.sendKeys(body);
        }

    public DraftsPage cancelSending () throws InterruptedException {
        cancelButton.click();
        goButton.click();
        Thread.sleep(1000);
        mailDraft.click();
        return new DraftsPage(driver);
    }

    public ComposePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
