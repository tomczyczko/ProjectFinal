package Pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceForeignPage {

    public InvoiceForeignPage(){
        PageFactory.initElements(Base.driver,this);
    }


    @FindBy(xpath = "//label[@for='legalStatusforeignCompany']")
    private WebElement foreignInvoiceCheckbox;


    @FindBy(xpath = "//app-complex-select[@class='w-100']/ng-select/div/div/div[2]/input")
    private WebElement prefNIP;

    @FindBy(xpath = "//input[@placeholder = 'Wpisz numer NIP']")
    private WebElement nipNumber;

    @FindBy(xpath = "//input[@placeholder='Wpisz nazwę firmy']")
    private WebElement companyName;

    @FindBy(xpath = "//*[@id='parcelForm']/div/div[1]/app-dynamic-form/form/app-section[22]/div/app-input/div/div/div/app-complex-select/ng-select/div/div/div[2]/input")

    private WebElement country;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.zipCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.town']")
    private WebElement town;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.street']")
    private WebElement streetName;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.buildingNo']")
    private WebElement buildingNumber;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.flatNo']")
    private WebElement flatNumber;

    @FindBy(xpath = "//input[@name='invoice.foreignCompany.email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//ul[@class='errors']/li")
    private WebElement errorMassage;



    public InvoiceForeignPage markForeign(){
        foreignInvoiceCheckbox.click();
        return this;
    }



    public InvoiceForeignPage choosePrefix (String prefix){
        prefNIP.click();
        prefNIP.sendKeys(prefix);
        prefNIP.sendKeys(Keys.ENTER);
        return this;

    }

    public InvoiceForeignPage enterNIP(String number){

        nipNumber.sendKeys(number);
        return this;
    }

    public InvoiceForeignPage enterCompanyName(String name){
        companyName.sendKeys(name);
        return this;
    }

    public InvoiceForeignPage chooseCountry(String town){
        country.click();
        country.sendKeys(town);
        country.sendKeys(Keys.ENTER);
        return this;
    }

    public InvoiceForeignPage enterZipCode(String zip){
        zipCode.clear();
        zipCode.click();
        zipCode.clear();
        zipCode.sendKeys(zip);
        return this;

    }

    public InvoiceForeignPage enterTown(String name){
        town.sendKeys(name);
        return this;
    }

    public InvoiceForeignPage enterStreetName(String name){
        streetName.sendKeys(name);
        return this;
    }

    public InvoiceForeignPage buildingDetails(String buildNumber, String flNumber){
        buildingNumber.sendKeys(buildNumber);
        flatNumber.sendKeys(flNumber);
        return this;
    }

    public InvoiceForeignPage enterEmail(String email){
        emailAddress.sendKeys(email);
        return this;
    }

    public String getErrorMassage(){
        return errorMassage.getText();

    }
}
