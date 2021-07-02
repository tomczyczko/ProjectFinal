package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SenderPage {

    public SenderPage(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(xpath = "//input[@name='senderAddress.name']")
    private WebElement senderName;

    @FindBy(xpath = "//input[@name='senderAddress.email']")
    private WebElement senderMailAddress;

    @FindBy(xpath = "//input[@name='senderAddress.phoneNum']")
    private WebElement senderPhoneNumber;

    @FindBy(xpath = "//label[@class='checkbox']/div")
    private WebElement invoice;

    @FindBy(xpath = "//div[@class='input-element error-control']/app-error/small/ul/li")
    private WebElement errorMassage;



    public SenderPage enterName(String name){
        senderName.sendKeys(name);
        return this;
    }

    public SenderPage enterMailAddress(String mail){
        senderMailAddress.sendKeys(mail);
        return this;

    }

    public SenderPage enterPhoneNumber(String number){
        senderPhoneNumber.sendKeys(number);
        return this;

    }

    public SenderPage markInvoice(){
        invoice.click();
        return this;

    }

    public String getMissingInformationMassage(){
        return errorMassage.getText();
    }

}
