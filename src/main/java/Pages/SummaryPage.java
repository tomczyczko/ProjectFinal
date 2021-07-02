package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SummaryPage {



    public SummaryPage(){
        PageFactory.initElements(Base.driver,this);
    }



    @FindBy(xpath = "//div[@class='sticky-element']/app-parcel-form-summary/div/div/ul/li[3]/div/div/div/div/div/app-input-checkbox/div/label/span/span")
    private WebElement promoCodeCheckBox;

    @FindBy(xpath = "//div[@class='sticky-element']/app-parcel-form-summary/div/div[2]/div/span[2]")
    private WebElement price;

    @FindBy(xpath = "//div[@class='sticky-element']/app-parcel-form-summary/div/div/ul/li[2]/div/div/div/div")
    private WebElement parcelSize;


    @FindBy(xpath = "//div[@class='sticky-element']/app-parcel-form-summary/div/div/ul/li[3]/div/div/div/div/div[2]/input")
    private WebElement promoCode;


    @FindBy(xpath = "//div[@class='d-flex justify-content-between buttons']/div[2]/button")
    private WebElement payButton;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between buttons']/div/button")
    private WebElement cancelPayment;

    @FindBy(xpath = "//div[@class='first-column']/div")
    private WebElement nameOnSummaryRecipient;

    @FindBy(xpath = "//div[@class='first-column']/div[2]")
    private WebElement phoneOnSummaryRecipient;

    @FindBy(xpath = "//div[@class='first-column']/div[3]")
    private WebElement mailAddressOnSummaryRecipient;

    @FindBy(xpath = "//div[@class='first-column mb-3']/div")
    private WebElement nameOnSummarySender;

    @FindBy(xpath = "//div[@class='first-column mb-3']/div[2]")
    private WebElement phoneNumberOnSummarySender;


    @FindBy(xpath = "//div[@class='first-column mb-3']/div[3]")
    private WebElement mailAddressOnSummarySender;

    @FindBy(xpath = "//modal-container[@class='modal fade show']/div/div/div/h4")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[2]/div/div[2]/div/div[2]/img")
    private WebElement parcelSizePhoto;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[1]/ul/li[1]/div/div/div/div[2]/img[2]")
    private WebElement deliveryPhoto;




    public SummaryPage enterPromoCode(String code){
        promoCodeCheckBox.click();
        promoCode.sendKeys(code);
        return this;

    }

    public String getParcelSize(){
        return parcelSize.getText();
    }

    public String getPrice(){
       return price.getText();
    }

    public SummaryPage pay(){
        payButton.click();
        return this;
    }

    public SummaryPage reenterData() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        cancelPayment.click();
        return this;
    }

    public String getNameOnSummaryRecipient(){
        return nameOnSummaryRecipient.getAttribute("innerHTML");
    }

    public String getPhoneNumberOnSummaryRecipient(){
        return phoneOnSummaryRecipient.getAttribute("innerHTML");
    }

    public String getMailAddressOnSummaryRecipient(){
        return mailAddressOnSummaryRecipient.getAttribute("innerHTML");
    }

    public String getNameOnSummarySender(){
        return nameOnSummarySender.getAttribute("innerHTML");
    }
    public String getPhoneNumberOnSummarySender(){
        return phoneNumberOnSummarySender.getAttribute("innerHTML");
    }

    public String getMailAddressOnSummarySender(){
        return mailAddressOnSummarySender.getAttribute("innerHTML");
    }

    public String getTitle(){
        return title.getAttribute("innerHTML");
    }

    public String getParcelPhoto(){
        return parcelSizePhoto.getAttribute("src");
    }

    public String getDeliveryPhoto(){
        return deliveryPhoto.getAttribute("src");
    }



}
