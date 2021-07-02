package Priority_P0;

import Pages.*;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class SummaryTest extends Base {

    //Inicjalizacja stron potrzebnych do wykanania testów
    DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
    SummaryPage summaryPage = new SummaryPage();
    SenderPage senderPage = new SenderPage();
    RecipientPage recipientPage = new RecipientPage();
    AgreementPage agreementPage = new AgreementPage();
    PaymentPage paymentPage = new PaymentPage();
    ConfirmPaymentPage confirmPaymentPage = new ConfirmPaymentPage();
    SummaryAfterPaymentPage summaryAfterPaymentPage = new SummaryAfterPaymentPage();

    //Metoda do odświeżania strony po każdym teście
    @After
    public void refresh(){
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
    }

    @Test
    @DisplayName("Parcel size should match the option chosen by the user")
    public void shouldDisplayCorrectParcelSizeOnSummary_ParcelToParcel(){
        deliveryTypePage.chooseParcelToParcel();
        deliveryTypePage.chooseParcelSizeA();
        assertEquals(deliveryTypePage.getParcelSizeA_text(),summaryPage.getParcelSize());

        deliveryTypePage.chooseParcelSizeB();
        assertEquals(deliveryTypePage.getParcelSizeB_text(),summaryPage.getParcelSize());

        deliveryTypePage.chooseParcelSizeC();
        assertEquals(deliveryTypePage.getParcelSizeC_text(),summaryPage.getParcelSize());

    }

    @Test
    @DisplayName("Parcel size should match the option chosen by the user")
    public void shouldDisplayCorrectParcelSizeOnSummary_ParcelToHome(){

        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeA();
        assertEquals(deliveryTypePage.getParcelSizeA_text(),summaryPage.getParcelSize());

        deliveryTypePage.chooseParcelSizeB();
        assertEquals(deliveryTypePage.getParcelSizeB_text(),summaryPage.getParcelSize());

        deliveryTypePage.chooseParcelSizeC();
        assertEquals(deliveryTypePage.getParcelSizeC_text(),summaryPage.getParcelSize());

    }

    @Test
    @DisplayName("Parcel price should match what is shown on page when user selects parcel size, parcel to parcel option")
    public void shouldDisplayCorrectParcelPriceOnSummary_ParcelToParcel(){
        deliveryTypePage.chooseParcelToParcel();

        deliveryTypePage.chooseParcelSizeA();
        assertEquals(deliveryTypePage.getPriceParcelSizeA(),summaryPage.getPrice());

        deliveryTypePage.chooseParcelSizeB();
        assertEquals(deliveryTypePage.getPriceParcelSizeB(),summaryPage.getPrice());

        deliveryTypePage.chooseParcelSizeC();
        assertEquals(deliveryTypePage.getPriceParcelSizeC(),summaryPage.getPrice());
    }


    @Test
    @DisplayName("Parcel price should match what is shown on page when user selects parcel size, parcel to home option")
    public void shouldDisplayCorrectParcelPriceOnSummary_ParcelToHome(){
        deliveryTypePage.chooseParcelToHome();

        deliveryTypePage.chooseParcelSizeA();
        assertEquals(deliveryTypePage.getPriceParcelSizeA(),summaryPage.getPrice());

        deliveryTypePage.chooseParcelSizeB();
        assertEquals(deliveryTypePage.getPriceParcelSizeB(),summaryPage.getPrice());

        deliveryTypePage.chooseParcelSizeC();
        assertEquals(deliveryTypePage.getPriceParcelSizeC(),summaryPage.getPrice());
    }

    @Test
    @DisplayName("The name of sender and recipient should match to what was entered by the user")
    public void shouldShowTheSameNameAsEnteredByTheUser() throws InterruptedException {
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
        assertEquals("Michał Tomczyk",summaryPage.getNameOnSummaryRecipient());
        assertEquals("Michał Zając",summaryPage.getNameOnSummarySender());
    }

    @Test
    @DisplayName("The phone number of sender and recipient should match to what was entered by the user")
    public void shouldShowTheSamePhoneNumberAsEnteredByTheUser() throws InterruptedException {
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
        assertEquals("737 879 839",summaryPage.getPhoneNumberOnSummaryRecipient());
        assertEquals("123 456 789",summaryPage.getPhoneNumberOnSummarySender());
    }

    @Test
    @DisplayName("The mail address of sender and recipient should match to what was entered by the user")
    public void shouldShowTheSameMailAddressAsEnteredByTheUser() throws InterruptedException {
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
        assertEquals("mitomczyk@inpost.pl",summaryPage.getMailAddressOnSummaryRecipient());
        assertEquals("mzajac@inpot.pl",summaryPage.getMailAddressOnSummarySender());
    }




    @Test
    @DisplayName("Given that the user won't accept terms, he should not be allowed to go to summary")
    public void shouldNotAllowToGoToSummary() throws InterruptedException {
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterParcelLocation("Wielicka 28 B Kraków");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.goToSummary();
        assertEquals("POLE WYMAGANE",agreementPage.getErrorMassage());
    }

    @Test
    @DisplayName("Parcel image should match the option chosen by the user")
    public void shouldDisplayCorrectParcelImageOnSummary_ParcelToParcel(){
        deliveryTypePage.chooseParcelToParcel();
        deliveryTypePage.chooseParcelSizeA();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryPage.getParcelPhoto());

       deliveryTypePage.chooseParcelSizeB();
       assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryPage.getParcelPhoto());


       deliveryTypePage.chooseParcelSizeC();
       assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryPage.getParcelPhoto());

    }


    @Test
    @DisplayName("Parcel image should match the option chosen by the user")
    public void shouldDisplayCorrectParcelImageOnSummary_ParcelToHome(){
        deliveryTypePage.chooseParcelToHome();
        deliveryTypePage.chooseParcelSizeA();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryPage.getParcelPhoto());

        deliveryTypePage.chooseParcelSizeB();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryPage.getParcelPhoto());


        deliveryTypePage.chooseParcelSizeC();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryPage.getParcelPhoto());

    }

    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeAOnSummaryBeforePayment_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel()
                .chooseParcelSizeA();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterParcelLocation("Wielicka 28 B Kraków");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeAOnSummaryBeforePayment_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeA();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }


    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeBOnSummaryBeforePayment_ParcelToParcel() throws InterruptedException {
        deliveryTypePage.chooseParcelToParcel()
                .chooseParcelSizeB();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("737879839")
                .enterParcelLocation("Wielicka 28 B Kraków");
        senderPage.enterName("Michał Zając")
                .enterMailAddress("mzajac@inpot.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeBOnSummaryBeforePayment_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeB();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }


    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeCOnSummaryBeforePayment_ParcelToParcel() throws InterruptedException {
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Parcel icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSamePictureParcelSizeCOnSummaryBeforePayment_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeC();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0",summaryPage.getParcelPhoto());
    }

    @Test
    @DisplayName("Delivery icon on summary should be the same as delivery type chosen by user")
    public void shouldShowMatchingDeliveryPhoto(){
        deliveryTypePage.chooseParcelToParcel();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/boxmachine.svg?v=1.10.0",summaryPage.getDeliveryPhoto());

        deliveryTypePage.chooseParcelToHome();
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/address.svg?v=1.10.0",summaryPage.getDeliveryPhoto());
    }

    @Test
    @DisplayName("Delivery icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSameDeliveryPhotoOnSummaryBeforePayment_ParcelToParcel() throws InterruptedException {
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/boxmachine.svg?v=1.10.0", summaryPage.getDeliveryPhoto());

    }

    @Test
    @DisplayName("Delivery icon should match with what was shown to user on final summary before payment")
    public void shouldShowTheSameDeliveryPhotoOnSummaryBeforePayment_ParcelToHome() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeC();
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
        assertEquals("https://test-oneclick-pl.easypack24.net/SzybkieNadania/assets/icons/address.svg?v=1.10.0",summaryPage.getDeliveryPhoto());
        System.out.println("Szymon jest super");
    }

}
