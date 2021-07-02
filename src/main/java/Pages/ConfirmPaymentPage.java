package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPaymentPage {

    public ConfirmPaymentPage(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(xpath = "//button[@value='1']")
    private WebElement confirm;

    @FindBy(xpath = "//button[@value='2']")
    private WebElement decline;

    @FindBy(xpath = "//button[@value='3']")
    private WebElement pending;

    public void confirmPayment(){
        confirm.click();
    }

    public void declinePayment(){
        decline.click();
    }

    public void pendingPayment(){
        pending.click();
    }

}
