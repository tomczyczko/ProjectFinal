package Priority_P1;

import Pages.AgreementPage;
import Pages.Base;
import Pages.DeliveryTypePage;
import Pages.RecipientPage;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


public class RecipientParcelToParcelTest extends Base {

      DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
       RecipientPage recipientPage = new RecipientPage();
       AgreementPage agreementPage = new AgreementPage();


    @After
    public void refresh(){
        Base.driver.navigate().refresh();
        try {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }catch(Exception ignored){}    }



    @Test
    @DisplayName("Given that we not include recipient name in recipient page, there should be suitable massage")
    public void shouldShowMissingName() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterParcelLocation("Wielicka 28 Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());

    }

    @Test
    @DisplayName("Given that we not include mail address in recipient page, there should be suitable massage")
    public void shouldShowMissingMailAddress() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterName("Michał Tomczyk")
                    .enterPhoneNumber("123456789")
                    .enterParcelLocation("Wielicka 28 Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());

    }

    @Test
    @DisplayName("Given that we not include phone number in recipient page, there should be suitable massage")
    public void shouldShowMissingPhoneNumber() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterName("Michał Tomczyk")
                    .enterMail("mitomczyk@inpost.pl")
                    .enterParcelLocation("Wielicka 28 Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());

    }


    @Test
    @DisplayName("Given that we not include Parcel location in recipient page, there should be suitable massage")
    public void shouldShowMissingParcelLocation(){
        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterName("Michał Tomczyk")
                    .enterMail("mitomczyk@test.pl")
                    .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given incorrect mail address, there should be adequate massage")
    public void shouldShowWrongMailAddress() throws InterruptedException {

        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyktest.pl")
                .enterPhoneNumber("123456789")
                .enterParcelLocation("Wielicka 28 Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL", recipientPage.getMissingInformationMassage());
    }
    @Test
    @DisplayName("Given incorrect phone number, there should be adequate massage")
    public void shouldShowWrongPhoneNumber() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("1111111111111")
                .enterParcelLocation("Wielicka 28 Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY NUMER TELEFONU", recipientPage.getMissingInformationMassage());
    }


}
