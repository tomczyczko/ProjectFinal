package Pages;

import Helper.ActionPage;
import Helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SummaryAfterPaymentPage {

   WaitPage waitPage = new WaitPage();


    public SummaryAfterPaymentPage(){
        PageFactory.initElements(Base.driver, this);


    }
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookies;

    @FindBy(xpath = "//button[@class='btn btn-primary position-relative with-loader']")
    private WebElement refresh;


    @FindBy(xpath = "//div[@class='text-wrapper longText']/span")
    private WebElement massage;

    @FindBy(xpath = "//div[@class='row price paid']/div")
    private WebElement paidStatus;

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

    @FindBy(xpath = "//*[@id=\"publicPage\"]/div[2]/app-summary/section[2]/div/div/app-parcel-form-whole-summary/div/ul/li[1]/div/div[1]/div/div/div/div[3]/img")
    private WebElement deliveryPhoto;

    @FindBy(xpath = "//*[@id=\"publicPage\"]/div[2]/app-summary/section[2]/div/div/app-parcel-form-whole-summary/div/ul/li[1]/div/div[2]/div/div[2]/img")
    private WebElement parcelPhoto;

    @FindBy(xpath = "//*[@id=\"publicPage\"]/div[2]/app-summary/section[2]/div/div/app-parcel-form-whole-summary/div/ul/li[1]/div/div[2]/div/div[2]/h4")
    private WebElement parcelSize;

    public void refreshPage() throws InterruptedException {
        cookies.click();
        waitPage.waitUntilElement(refresh);
        int count = 0;
        try {
            waitPage.waitUntilElement(refresh);
            while (massage.getText().contains("Twoja transakcja nie została jeszcze zakończona")&& count < 5) {
                refresh.click();
                TimeUnit.SECONDS.sleep(5);
                count++;
            }
        }catch (Exception ignored){}
    }

    public String status(){
        return paidStatus.getText();
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

    public String getDeliveryPhoto(){
        return deliveryPhoto.getAttribute("src");
    }

    public String getParcelPhoto(){
        return parcelPhoto.getAttribute("src");
    }

    public String getParcelSize(){
        return parcelSize.getText();
    }

}
