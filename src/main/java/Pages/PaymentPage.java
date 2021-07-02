package Pages;

import Helper.ActionPage;
import Helper.WaitPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PaymentPage{

    public PaymentPage(){
        PageFactory.initElements(Base.driver,this);
    }
    WaitPage waitPage = new WaitPage();
    ActionPage actionPage = new ActionPage();

    @FindBy(xpath = "//div[@title='VISA']")
    private WebElement visaCard;

    @FindBy(xpath = "//div[@title='MasterCard']")
    private WebElement masterCard;

    @FindBy(xpath = "//div[@title='Maestro']")
    private WebElement maestroCard;

    @FindBy(xpath = "//input[@id='card-number']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@autocomplete='cc-exp-month']")
    private WebElement month;

    @FindBy(xpath = "//input[@autocomplete='cc-exp-year']")
    private WebElement year;

    @FindBy(xpath = "//input[@name='card-cvv2']")
    private WebElement cvc2;

    @FindBy(xpath = "//div[@title='mTransfer']")
    private WebElement mbank;

    @FindBy(xpath = "//input[@name='EMAIL']")
    private WebElement mailAddress;

  // @FindBy(xpath = "//*[@id=\"blikPaymentForm\"]/div[7]/button[1]")
    @FindBy(xpath = "//button[@class='finish-button active']")
    private WebElement payButton;

    @FindBy(xpath = "//ul[@id='parsley-id-13']/li")
    private WebElement wrongCardNumber;

    @FindBy(xpath = "//button[@class='finish-button']")
    private WebElement payButtonInactive;



    @FindBy(xpath = "//form[@id='blikPaymentForm']/div[7]/div")
    private WebElement noCardInfo;

    @FindBy(xpath = "//ul[@id='parsley-id-15']/li")
    private WebElement wrongMonth;

    @FindBy(xpath = "//ul[@id='parsley-id-17']/li")
    private WebElement wrongYear;

    @FindBy(xpath = "//ul[@id='parsley-id-19']/li")
    private WebElement wrongCvc;

    @FindBy(xpath = "//div[@class='main col-lg-5']/section/p")
    private WebElement name;

    @FindBy(xpath = "//div[@class='main col-lg-5']/section/p[2]")
    private WebElement mailAddressSender;

    @FindBy(xpath = "//div[@class='main col-lg-5']/section/p[3]")
    private WebElement price;


    public PaymentPage moveToPayButton(){
        actionPage.moveToElement(payButtonInactive);
        return this;

    }

    public PaymentPage markVisa(){
        visaCard.click();
        return this;
    }


    public PaymentPage markMasterCard(){
        masterCard.click();
        return this;
    }

    public PaymentPage markMaestroCard(){
        maestroCard.click();
        return this;
    }

    public PaymentPage enterMonth(String cardMonth){
        month.sendKeys(cardMonth);
        return this;
    }

    public PaymentPage enterYear(String cardYear){
        year.sendKeys(cardYear);
        return this;
    }

    public PaymentPage enterCardNumber(String number){
        cardNumber.sendKeys(number);
        return this;
    }

    public PaymentPage enterCvc(String cvc){
        cvc2.sendKeys(cvc);
        return this;
    }

    public PaymentPage chooseMbank(){
        waitPage.waitUntilElement(mbank);
        mbank.click();
        return this;
    }

    public PaymentPage enterMailAddress(String mail){
        mailAddress.sendKeys(mail);
        return this;
    }

    public PaymentPage pay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        payButton.click();
        return this;
    }

    public String getNameSender(){
        return name.getText();
    }

    public String getPrice(){
        return price.getText();
    }

    public String getMailAddressOfSender(){
        return mailAddressSender.getText();
    }

    public String incorrectCardNumber(){
        return wrongCardNumber.getText();
    }

    public String noCardInformation(){
        return noCardInfo.getText();
    }

    public String wrongMonth(){
        return wrongMonth.getText();
    }

    public String wrongYear(){
        return wrongYear.getText();
    }

    public String wrongCvc2(){
        return wrongCvc.getText();
    }
}
