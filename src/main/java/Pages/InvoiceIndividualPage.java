package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class InvoiceIndividualPage{

    public InvoiceIndividualPage(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(xpath = "//label[@for='legalStatusindividual']")
    private WebElement individual;

    @FindBy(xpath = "//input[@name='invoice.individual.companyName']")
    private WebElement individualName;

    @FindBy(xpath = "//input[@name='invoice.individual.email']")
    private WebElement mailAddress;

    @FindBy(xpath = "//input[@name='invoice.individual.zipCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//ng-select[@name='invoice.individual.town']/div/div/div[2]/input")
    private WebElement city;

    @FindBy(xpath = "//ng-select[@name='invoice.individual.street']/div/div/div[2]/input")
    private WebElement street;


    @FindBy(xpath = "//input[@name='invoice.individual.buildingNo']")
    private WebElement buildingNumber;

    @FindBy(xpath = "//input[@name='invoice.individual.flatNo']")
    private WebElement flatNumber;

    @FindBy(xpath = "//app-section[@class='col-12 left right sections-combined']/div/app-input/div/div/div/app-form-button")
    private WebElement copySenderInfo;


    @FindBy(xpath = "//ul[@class='errors']/li")
    private WebElement errorMassage;



    public InvoiceIndividualPage markIndividual(){
        individual.click();
        return this;
    }

    public InvoiceIndividualPage enterName(String name){
        individualName.sendKeys(name);
        return this;

    }

    public InvoiceIndividualPage enterMailAddress(String mail){
        mailAddress.sendKeys(mail);
        return this;

    }

    public InvoiceIndividualPage enterZipCode(String zip){
        zipCode.sendKeys(zip);
        return this;

    }

    public InvoiceIndividualPage enterCity(String town) throws InterruptedException {
        city.click();
        city.sendKeys(town);
        TimeUnit.SECONDS.sleep(2);
        city.sendKeys(Keys.ENTER);
        return this;

    }

    public InvoiceIndividualPage enterStreet(String nameOfStreet) throws InterruptedException {
        street.click();
        street.sendKeys(nameOfStreet);
        TimeUnit.SECONDS.sleep(2);
        street.sendKeys(Keys.ENTER);
        return this;

    }

    public InvoiceIndividualPage apartmentDetails(String bNumber, String fNumber){
        buildingNumber.sendKeys(bNumber);
        flatNumber.sendKeys(fNumber);
        return this;
    }

    public InvoiceIndividualPage copySenderInformation(){
        copySenderInfo.click();
        return this;
    }

    public String getErrorMassage(){
        return errorMassage.getText();
    }

}
