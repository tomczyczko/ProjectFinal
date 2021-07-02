package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class RecipientPage extends Base{

    public RecipientPage(){
        PageFactory.initElements(Base.driver,this);
    }

    @FindBy(xpath = "//input[@name='targetAddress.name']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='addresseeEmail']")
    private WebElement mailAddress;

    @FindBy(xpath = "//input[@placeholder='Wpisz numer telefonu']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//app-input[@class='mobile-label flex-row boxMachineName app-input form-group']/div/div/div/app-points-select/ng-select/div/div/div[2]/input")
    private WebElement parcelLocation;

    @FindBy(xpath = "//input[@name='targetAddress.zipCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//ng-select[@name='targetAddress.town']/div/div/div[2]/input")
    private WebElement city;

    @FindBy(xpath = "//ng-select[@name='targetAddress.street']/div/div/div[2]/input")
    private WebElement street;

    @FindBy(xpath = "//input[@name='targetAddress.buildingNo']")
    private WebElement buildingNumber;

    @FindBy(xpath = "//input[@name='targetAddress.flatNo']")
    private WebElement flatNumber;

    @FindBy(xpath = "//label[@for='courier_comment_changer']/span")
    private WebElement additionalInfoCheckBox;

    @FindBy(xpath = "//input[@name='customerReference']")
    private WebElement additionalInformation;

    @FindBy(xpath = "//span[@id='error-customerReference']/small/ul/li")
    private WebElement toLongMassageInformation;

    @FindBy(xpath = "//span[@class='d-flex content']")
    private WebElement map;

    @FindBy(xpath = "//input[@name='easypack-search']")
    private WebElement searchBarOnMap;

    @FindBy(xpath = "//div[@class='input-element error-control']/app-error/small/ul/li")
    private WebElement errorMassage;



    public RecipientPage enterName(String recipientsName){
        name.sendKeys(recipientsName);
        return this;
    }

    public RecipientPage enterMail(String recipientsMail){
        mailAddress.sendKeys(recipientsMail);
        return this;

    }

    public RecipientPage enterPhoneNumber(String recipientsPhone){
        phoneNumber.sendKeys(recipientsPhone);
        return this;

    }

    public RecipientPage enterParcelLocation(String location) throws InterruptedException {
        parcelLocation.click();
        parcelLocation.sendKeys(location);
        TimeUnit.SECONDS.sleep(2);
        parcelLocation.sendKeys(Keys.ENTER);
        return this;

    }

    public RecipientPage enterZipCode(String zip){
        zipCode.sendKeys(zip);
        return this;

    }

    public RecipientPage enterCity(String town) throws InterruptedException {
        city.click();
        TimeUnit.SECONDS.sleep(1);
        city.sendKeys(town);
        TimeUnit.SECONDS.sleep(1);
        city.sendKeys(Keys.ENTER);
        return this;

    }

    public RecipientPage enterStreet(String nameOfStreet) throws InterruptedException {
        street.click();
        TimeUnit.SECONDS.sleep(1);
        street.sendKeys(nameOfStreet);
        TimeUnit.SECONDS.sleep(1);
        street.sendKeys(Keys.ENTER);
        return this;

    }

    public RecipientPage enterBuildingDetails(String bNumber, String fNumber){
        buildingNumber.sendKeys(bNumber);
        flatNumber.sendKeys(fNumber);
        return this;

    }

    public RecipientPage enterAdditionalInformation(String information){
        additionalInfoCheckBox.click();
        additionalInformation.sendKeys(information);
        return this;

    }

    public RecipientPage clickMap(){
        map.click();
        return this;

    }

    public RecipientPage enterParcelLocationOnMap(String location){
        searchBarOnMap.sendKeys(location);
        searchBarOnMap.sendKeys(Keys.ENTER);
        return this;

    }

    public String getErrorMassageAdditionalInformation(){
        return toLongMassageInformation.getText();
    }

    public String getMissingInformationMassage(){
        return errorMassage.getText();
    }
}
