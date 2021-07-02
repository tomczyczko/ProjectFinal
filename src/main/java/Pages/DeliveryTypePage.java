package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DeliveryTypePage{


    public DeliveryTypePage(){
        PageFactory.initElements(Base.driver,this);

    }


    @FindBy(xpath = "//div[@class='input-group full-radio mobile-wrap input-group--no-hint']/app-input-radio/span/label")
    private WebElement parcelToParcel;


    @FindBy(xpath = "//div[@class='input-group full-radio mobile-wrap input-group--no-hint']/app-input-radio/span[2]/label")
    private WebElement parcelToHome;

    @FindBy(xpath = "//label[@for='parcelSizeA']/span")
    private WebElement parcelSizeA;

    @FindBy(xpath = "//label[@for='parcelSizeB']/span")
    private WebElement parcelSizeB;

    @FindBy(xpath = "//label[@for='parcelSizeC']/span")
    private WebElement parcelSizeC;


    @FindBy(xpath = "//label[@for='parcelSizeA']/div/app-parcel-options/div/div/div/p[2]")
    private WebElement priceParcelSizeA;

    @FindBy(xpath = "//label[@for='parcelSizeB']/div/app-parcel-options/div/div/div/p[2]")
    private WebElement priceParcelSizeB;

    @FindBy(xpath = "//label[@for='parcelSizeC']/div/app-parcel-options/div/div/div/p[2]")
    private WebElement priceParcelSizeC;

    @FindBy(xpath = "//label[@for='parcelSizeA']/div/app-parcel-options/div/div/span")
    private WebElement parcelSizeA_text;

    @FindBy(xpath = "//label[@for='parcelSizeB']/div/app-parcel-options/div/div/span")
    private WebElement parcelSizeB_text;

    @FindBy(xpath = "//label[@for='parcelSizeC']/div/app-parcel-options/div/div/span")
    private WebElement parcelSizeC_text;




    public DeliveryTypePage chooseParcelToParcel(){
        parcelToParcel.click();
        return this;
    }

    public DeliveryTypePage chooseParcelToHome(){
        parcelToHome.click();
        return this;
    }

    public DeliveryTypePage chooseParcelSizeA(){
        parcelSizeA.click();
        return this;
    }
    public DeliveryTypePage chooseParcelSizeB(){
        parcelSizeB.click();
        return this;
    }
    public DeliveryTypePage chooseParcelSizeC(){
        parcelSizeC.click();
        return this;
    }

    public String getPriceParcelSizeA(){
        return priceParcelSizeA.getText();
    }

    public String getPriceParcelSizeB(){
        return priceParcelSizeB.getText();
    }

    public String getPriceParcelSizeC(){
        return priceParcelSizeC.getText();
    }

    public String getParcelSizeA_text(){
        return parcelSizeA_text.getText();
    }
    public String getParcelSizeB_text(){
        return parcelSizeB_text.getText();
    }
    public String getParcelSizeC_text(){
        return parcelSizeC_text.getText();
    }


}
