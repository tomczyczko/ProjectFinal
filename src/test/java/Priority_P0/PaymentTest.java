package Priority_P0;


import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


public class PaymentTest extends Base {

    //Inicjalizacja stron potrzebnych do wykonania testów

    DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
    RecipientPage recipientPage = new RecipientPage();
    SenderPage senderPage = new SenderPage();
    AgreementPage agreementPage = new AgreementPage();
    PaymentPage paymentPage = new PaymentPage();
    SummaryPage summaryPage = new SummaryPage();

    //Metoda służąca do przejścia do strony płatoności, wykonuje się przed każdym testem
    @Before
    public void goToPayment() throws InterruptedException {
            recipientPage.enterName("Michał Tomczyk")
                        .enterMail("mitomczyk@inpost.pl")
                        .enterPhoneNumber("1234567898")
                        .enterParcelLocation("Kraków Wielicka 28");
            senderPage.enterName("Jan Kowaslki")
                    .enterMailAddress("test@test.pl")
                    .enterPhoneNumber("123123123");
            agreementPage.markTerms().goToSummary();
            summaryPage.pay();
    }

    //Metoda służąca do powrotu do strony początkowej po każdym teście
    @After
    public void refresh(){
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
    }

    @Test
    @DisplayName("Given incorrect card number for Visa card, there should be adequate massage")
    public void shouldShowIncorrectCardNumber_Visa(){
        paymentPage.markVisa()
                    .enterCardNumber("1111");
        assertEquals("Nieprawidłowy numer karty",paymentPage.incorrectCardNumber());
    }

    @Test
    @DisplayName("Given incorrect card number for Visa card, there should be adequate massage")
    public void shouldShowIncorrectCardNumber_MasterCard(){
        paymentPage.markMasterCard()
                .enterCardNumber("1111");
        assertEquals("Nieprawidłowy numer karty",paymentPage.incorrectCardNumber());
    }

    @Test
    @DisplayName("Given incorrect card number for Visa card, there should be adequate massage")
    public void shouldShowIncorrectCardNumber_Maestro(){
        paymentPage.markMaestroCard()
                .enterCardNumber("1111");
        assertEquals("Nieprawidłowy numer karty",paymentPage.incorrectCardNumber());
    }
    @Test
    @DisplayName("Given that not enough information is given, going further shouldn't be possible")
    public void shouldNotAllowGoFurtherWithoutPaymentDetails(){
        paymentPage.moveToPayButton();
        assertEquals("Aby przejść dalej wybierz formę płatności i  uzupełnij wymagane pola",paymentPage.noCardInformation());
    }

    @Test
    @DisplayName("Given incorrect month, there should be adequate massage")
    public void shouldShowIncorrectMonth(){
        paymentPage.markVisa().enterMonth("45");
        assertEquals("Wartość z przedziału od 1 do 12.",paymentPage.wrongMonth());
    }

    @Test
    @DisplayName("Given incorrect year, there should be adequate massage")
    public void shouldShowIncorrectYear(){
        paymentPage.markVisa().enterMonth("12").enterYear("1525");
        assertEquals("Wartość z przedziału od 2021 do 2036.",paymentPage.wrongYear());
    }

    @Test
    @DisplayName("Given incorrect Cvc2 code, there should be adequate massage")
    public void shouldShowIncorrectCvc(){
        paymentPage.markVisa().enterCvc("14");
        assertEquals("Ilość znaków powinna wynosić 3 lub więcej.",paymentPage.wrongCvc2());
    }

    @Test
    @DisplayName("Sender of package that was entered by the user should match the one on summary page")
    public void shouldMatchNameSender(){
        assertEquals("Jan Kowaslki",paymentPage.getNameSender());
    }

    @Test
    @DisplayName("Mail address of sender should match with what was entered by the user with what is shown on summary page")
    public void shouldMatchMailAddressSender(){
        String[] mailAddress = paymentPage.getMailAddressOfSender().split(" ");
        assertEquals("test@test.pl",mailAddress[0]);
    }

    @Test
    @DisplayName("The price should match with what was shown and chosen by user, considering delivery form and parcel size")
    public void shouldMatchPriceParcelToParcel_ParcelSizeA() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToParcel()
                        .chooseParcelSizeA();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("1234567898")
                .enterParcelLocation("Kraków Wielicka 28");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("12,99 PLN",paymentPage.getPrice());
    }

    @Test
    @DisplayName("The price should match with what was shown and chosen by user, considering delivery form and parcel size")
    public void shouldMatchPriceParcelToParcel_ParcelSizeB() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToParcel()
                .chooseParcelSizeB();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("1234567898")
                .enterParcelLocation("Kraków Wielicka 28");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("13,99 PLN",paymentPage.getPrice());
    }


    @Test
    public void shouldMatchPriceParcelToParcel_ParcelSizeC() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToParcel()
                .chooseParcelSizeC();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@inpost.pl")
                .enterPhoneNumber("1234567898")
                .enterParcelLocation("Kraków Wielicka 28");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("15,49 PLN",paymentPage.getPrice());
    }

    @Test
    @DisplayName("The price should match with what was shown and chosen by user, considering delivery form and parcel size")
    public void shouldMatchPriceParcelToHome_ParcelSizeA() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeA();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("14,99 PLN",paymentPage.getPrice());
    }

    @Test
    @DisplayName("The price should match with what was shown and chosen by user, considering delivery form and parcel size")
    public void shouldMatchPriceParcelToHome_ParcelSizeB() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeB();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("16,49 PLN",paymentPage.getPrice());
    }

    @Test
    @DisplayName("The price should match with what was shown and chosen by user, considering delivery form and parcel size")
    public void shouldMatchPriceParcelToHome_ParcelSizeC() throws InterruptedException {
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        deliveryTypePage.chooseParcelToHome()
                .chooseParcelSizeC();
        recipientPage.enterName("Mateusz Fąfara")
                .enterMail("mfafara@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("32-040")
                .enterCity("Wrząsowice")
                .enterStreet("Gazdy")
                .enterBuildingDetails("11","2");
        senderPage.enterName("Jan Kowaslki")
                .enterMailAddress("test@test.pl")
                .enterPhoneNumber("123123123");
        agreementPage.markTerms().goToSummary();
        summaryPage.pay();
        assertEquals("19,99 PLN",paymentPage.getPrice());
    }



}
