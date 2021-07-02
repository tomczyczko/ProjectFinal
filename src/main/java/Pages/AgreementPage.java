package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgreementPage {

    public AgreementPage(){
        PageFactory.initElements(Base.driver,this);
    }


    @FindBy(xpath = "//label[@for='terms']")
    private WebElement terms;

    @FindBy(xpath = "//label[@for='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg position-relative with-loader w-100']")
    private WebElement summary;

    @FindBy(xpath = "//ul[@class='errors']/li")
    private WebElement errorMassage;



    public AgreementPage markTerms(){
         terms.click();
         return this;
    }

    public AgreementPage markNewsletter(){
        newsletter.click();
        return this;
    }

    public AgreementPage goToSummary(){
        summary.click();
        return this;
    }

    public String getErrorMassage(){
        return errorMassage.getText();
    }
}
