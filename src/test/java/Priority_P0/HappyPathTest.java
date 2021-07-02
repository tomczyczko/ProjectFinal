package Priority_P0;

import Pages.*;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


public class HappyPathTest extends Base {

    //Inicjalizacja stron potrzebnych do wykonania testów

    SenderPage senderPage = new SenderPage();
    DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
    RecipientPage recipientPage = new RecipientPage();
    AgreementPage agreementPage = new AgreementPage();
    SummaryPage summaryPage = new SummaryPage();
    PaymentPage paymentPage = new PaymentPage();
    ConfirmPaymentPage confirmPaymentPage = new ConfirmPaymentPage();
    SummaryAfterPaymentPage summaryAfterPaymentPage = new SummaryAfterPaymentPage();

    //metoda odświeża do strony początkowej po wykaniu każdego testu, pozwalając na puszczenie wielu testów naraz
    @After
    public void refresh(){
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        try {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }catch(Exception ignored){}
    }

    //Happy Path strony przy sposobie dostawy paczkomat - paczkomat, test zostanie uznany za pozytywny kiedy
    //pojawi sie status "Opłacone" przy końcowym podsumowaniu po płatnośći
    @Test
    @DisplayName("Program should execute from the beginning to end, using delivery Parcel to Parcel")
    public void shouldExecuteFully_ParcelToParcel() throws InterruptedException {

        deliveryTypePage.chooseParcelToParcel()
                        .chooseParcelSizeC();
        recipientPage.enterName("Michał Tomczyk")
                    .enterMail("mitomczyk@inpost.pl")
                    .enterPhoneNumber("737879839")
                    .enterParcelLocation("Wielicka 28 B Kraków");
        senderPage.enterName("Michał Zając")
                    .enterMailAddress("mzajac@inpot.pl")
                    .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Opłacone",summaryAfterPaymentPage.status());
    }

    //Happy Path strony przy sposobie dostawy paczkomat - dom, test zostanie uznany za pozytywny kiedy
    //pojawi sie status "Opłacone" przy końcowym podsumowaniu po płatnośći
    @Test
    @DisplayName("Program should execute from the beginning to end, using delivery Parcel to home")
    public void shouldExecuteFully_ParcelToHome() throws InterruptedException {

        deliveryTypePage.chooseParcelToHome()
                        .chooseParcelSizeC();
        recipientPage.enterName("Mateusz Fąfara")
                    .enterMail("mfafara@test.pl")
                    .enterPhoneNumber("123456789")
                    .enterZipCode("32-040")
                    .enterCity("Wrząsowice")
                    .enterStreet("Gazdy")
                    .enterBuildingDetails("11","2")
                    .enterAdditionalInformation("Proszę krzyczeć jak będzie kurier");
        senderPage.enterName("Jan Sigsowrth")
                    .enterMailAddress("jsigsworth@test.pl")
                    .enterPhoneNumber("123456789");
        agreementPage.markTerms().markNewsletter().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank()
                    .pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Opłacone",summaryAfterPaymentPage.status());
    }


}
