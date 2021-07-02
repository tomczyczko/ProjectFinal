package Priority_P0;

import Pages.*;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class SummaryAfterPaymentTest extends Base {

    //Inicjalizacja stron potrzebnych do wykonania testów

    DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
    SummaryPage summaryPage = new SummaryPage();
    SenderPage senderPage = new SenderPage();
    RecipientPage recipientPage = new RecipientPage();
    AgreementPage agreementPage = new AgreementPage();
    PaymentPage paymentPage = new PaymentPage();
    ConfirmPaymentPage confirmPaymentPage = new ConfirmPaymentPage();
    SummaryAfterPaymentPage summaryAfterPaymentPage = new SummaryAfterPaymentPage();

    //Metoda służąca do powrotu do strony początkowej po każdym teście
    @After
    public void refresh() {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        try {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }catch(Exception ignored){}
    }


    @Test
    @DisplayName("The name of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSameNameAsEnteredByTheUser_ParcelToParcel() throws InterruptedException {

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
        assertEquals("Michał Tomczyk",summaryAfterPaymentPage.getNameOnSummaryRecipient());
        assertEquals("Michał Zając",summaryAfterPaymentPage.getNameOnSummarySender());
    }

    @Test
    @DisplayName("The phone number on summary of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSamePhoneNumberAsEnteredByTheUser_ParcelToParcel() throws InterruptedException {

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
        assertEquals("737 879 839",summaryAfterPaymentPage.getPhoneNumberOnSummaryRecipient());
        assertEquals("123 456 789",summaryAfterPaymentPage.getPhoneNumberOnSummarySender());
    }


    @Test
    @DisplayName("Mail address of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSameMailAddressAsEnteredByTheUser_ParcelToParcel() throws InterruptedException {

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
        assertEquals("mitomczyk@inpost.pl",summaryAfterPaymentPage.getMailAddressOnSummaryRecipient());
        assertEquals("mzajac@inpot.pl",summaryAfterPaymentPage.getMailAddressOnSummarySender());
    }

    @Test
    @DisplayName("The name of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSameNameAsEnteredByTheUser_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2")
                .enterAdditionalInformation("Proszę krzyczeć jak będzie kurier");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Michał Tomczyk",summaryAfterPaymentPage.getNameOnSummaryRecipient());
        assertEquals("Michał Zając",summaryAfterPaymentPage.getNameOnSummarySender());
    }


    @Test
    @DisplayName("The phone number on summary of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSamePhoneNumberAsEnteredByTheUser_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2")
                .enterAdditionalInformation("Proszę krzyczeć jak będzie kurier");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("737 879 839",summaryAfterPaymentPage.getPhoneNumberOnSummaryRecipient());
        assertEquals("123 456 789",summaryAfterPaymentPage.getPhoneNumberOnSummarySender());
    }

    @Test
    @DisplayName("Mail address of sender and recipient should match with what was entered by the user")
    public void shouldShowTheSameMailAddressAsEnteredByTheUser_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2")
                .enterAdditionalInformation("Proszę krzyczeć jak będzie kurier");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("mitomczyk@inpost.pl",summaryAfterPaymentPage.getMailAddressOnSummaryRecipient());
        assertEquals("mzajac@inpot.pl",summaryAfterPaymentPage.getMailAddressOnSummarySender());
    }

    @Test
    @DisplayName("Delivery icon should match with delivery type chosen by the user")
    public void shouldMatchDeliveryPhoto_ParcelToParcel() throws InterruptedException {
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/boxmachine.svg?v=1.10.0",summaryAfterPaymentPage.getDeliveryPhoto());
    }

    @Test
    @DisplayName("Delivery icon should match with delivery type chosen by the user")
    public void shouldMatchDeliveryPhoto_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/address.svg?v=1.10.0",summaryAfterPaymentPage.getDeliveryPhoto());
    }

    @Test
    @DisplayName("Parcel icon should match with chosen parcel size")
    public void shouldMathParcelPhotoA_ParcelToParcel() throws InterruptedException {
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Parcel description should be the same as one chosen by the user")
    public void shouldMathParcelSizeA_ParcelToParcel() throws InterruptedException {
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
        assertEquals("Mała",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel icon should be the same as one chosen in the beginning")
    public void shouldMathParcelPhotoB_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelSizeB();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }
    @Test
    @DisplayName("Parcel description should be the same as chosen by the user")
    public void shouldMathParcelSizeB_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelSizeB();
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
        assertEquals("Średnia",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel description should be the same as one chosen on delivery page")
    public void shouldMathParcelSizeC_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelSizeC();
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
        assertEquals("Duża",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel icon should be the same as one chosen by the user in the delivery page")
    public void shouldMathParcelPhotoC_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelSizeC();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }


    @Test
    @DisplayName("Parcel icon should be the same as one chosen by the user in the delivery page")
    public void shouldMathParcelPhotoA_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Parcel size should be the same as obe chosen by the user")
    public void shouldMathParcelSizeA_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Mała",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel icon should be the same as one chosen by the user in the delivery page")
    public void shouldMathParcelPhotoB_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeB();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }
    @Test
    @DisplayName("Parcel size description should be the same as one chosen by user")
    public void shouldMathParcelSizeB_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeB();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Średnia",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel size description should be the same as one chosen by user")
    public void shouldMathParcelSizeC_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeC();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("Duża",summaryAfterPaymentPage.getParcelSize());
    }

    @Test
    @DisplayName("Parcel icon should be the same as one chosen by the user in the delivery page")
    public void shouldMathParcelPhotoC_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeC();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        paymentPage.chooseMbank().pay();
        confirmPaymentPage.confirmPayment();
        summaryAfterPaymentPage.refreshPage();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryAfterPaymentPage.getParcelPhoto());
    }



}