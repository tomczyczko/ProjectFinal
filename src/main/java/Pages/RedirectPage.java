package Pages;

import Helper.ActionPage;
import Helper.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RedirectPage {

    public RedirectPage(){
        PageFactory.initElements(Base.driver, this);
    }

    WaitPage waitPage = new WaitPage();
    @FindBy(xpath = "//a[@href='https://inpost.pl']")
    private WebElement inpostLink;

    @FindBy(xpath = "//app-input[@class='section-input pr-0 app-input form-group']/div/span/span[2]")
    private WebElement howToSendPackage;

    @FindBy(xpath = "//app-section[@class='col-12 mt-3 title-section']/div/app-input[2]/div/span/span[2]")
    private WebElement howToPackPackage;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[3]/div/a")
    private WebElement guideToPackingPackage;

    @FindBy(xpath = "//a[@href='https://inpost.pl/regulaminy']")
    private WebElement termsOfUse;

    @FindBy(xpath = "//a[@href='http://integer.pl']")
    private WebElement integer;


    @FindBy(xpath = "//a[@href='https://inpost.pl/polityka-prywatnosci']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//a[@href='https://inpost.pl/kontakt/zloz-reklamacje']")
    private WebElement complaints;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookies;

    @FindBy(xpath = "/html/body/modal-container/div/div/div[1]/h4")
    private WebElement massageHowToSendPackage;

    @FindBy(xpath = "//a[@href='https://inpost.pl/pomoc?fulltext=szybkie+nadania']")
    private WebElement help;

    @FindBy(xpath = "//a[@href='https://inpost.pl/kontakt']")
    private WebElement contact;


    public void goToInpostPage(){
        inpostLink.click();
        cookies.click();
    }

    public void goToHowToSendPackage(){
        howToSendPackage.click();
    }

    public void goToHowToPackPackage() throws InterruptedException {
        howToPackPackage.click();
        TimeUnit.SECONDS.sleep(3);
        guideToPackingPackage.click();

    }

    public void enterTermOfUse(){
        termsOfUse.click();
    }

    public void goToInteger(){
        integer.click();
    }

    public void goToPrivacyPolicy(){
        privacyPolicy.click();
    }

    public void goToComplaints(){
        complaints.click();
    }

    public String howToSendPackageGuide(){
        return massageHowToSendPackage.getAttribute("innerHTML");
    }

    public void goToHelp(){
        help.click();
    }

    public void goToContact(){
        contact.click();
    }
}
