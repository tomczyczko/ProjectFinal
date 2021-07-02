package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePolandPage {

    public InvoicePolandPage(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(xpath = "//label[@for='legalStatuscompany']")
    private WebElement polishCompany;

    @FindBy(xpath = "//input[@name='invoice.company.nip']")
    private WebElement nipNumber;

    @FindBy(xpath = "//input[@name='invoice.company.companyName']")
    private WebElement companyName;

    @FindBy(xpath = "//input[@name='invoice.company.zipCode']")
    private WebElement zipCode;


    @FindBy(xpath = "//ng-select[@name='invoice.company.town']/div/div/div[2]/input")
    private WebElement city;

    @FindBy(xpath = "//ng-select[@name='invoice.company.street']/div/div/div[2]/input")
    private WebElement street;


    @FindBy(xpath = "//input[@name='invoice.company.buildingNo']")
    private WebElement buildingNumber;

    @FindBy(xpath = "//input[@name='invoice.company.flatNo']")
    private WebElement flatNumber;

    @FindBy(xpath = "//input[@name='invoice.company.email']")
    public WebElement mailAddress;

    @FindBy(xpath = "//ul[@class='errors']/li")
    private WebElement errorMassage;




    public InvoicePolandPage markPolishCompany(){
       polishCompany.click();
       return this;
    }

    public InvoicePolandPage enterNIP(String nip){
        nipNumber.sendKeys(nip);
        return this;
    }

    public InvoicePolandPage enterCompanyName(String name){
        companyName.sendKeys(name);
        return this;

    }

    public InvoicePolandPage enterZipCode(String zipNum){
        zipCode.sendKeys(zipNum);
        return this;
    }


    public InvoicePolandPage apartmentDetails(String bNumber, String fNumber){
        buildingNumber.sendKeys(bNumber);
        flatNumber.sendKeys(fNumber);
        return this;

    }

    public InvoicePolandPage enterMail(String mail){
        mailAddress.sendKeys(mail);
        return this;

    }

    public InvoicePolandPage enterCity(String town){
        city.click();
        city.sendKeys(town);
        city.sendKeys(Keys.ENTER);
        return this;

    }

    public InvoicePolandPage enterStreet(String nameOfStreet){
        street.click();
        street.sendKeys(nameOfStreet);
        street.sendKeys(Keys.ENTER);
        return this;

    }

    public String getErrorMassage(){
        return errorMassage.getText();
    }





}
