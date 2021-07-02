package Proprity_P2;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceForeignTest extends Base {

    SummaryPage summaryPage = new SummaryPage();
    SenderPage senderPage = new SenderPage();
    RecipientPage recipientPage = new RecipientPage();
    InvoiceForeignPage invoiceForeignPage_ = new InvoiceForeignPage();
    AgreementPage agreementPage = new AgreementPage();


    @Before
    public void fillSenderAndRecipientPage() throws InterruptedException {
        recipientPage.enterName("Test test")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterParcelLocation("Kraków Wielicka 28");
        senderPage.enterName("Drugi test")
                .enterMailAddress("drugitest@inpost.pl")
                .enterPhoneNumber("737879822")
                .markInvoice();
    }

    @After
    public void refresh(){
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        try {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }catch(Exception ignored){}    }


    @Test
    public void shouldNotAllowToGoToSummary(){
        invoiceForeignPage_.markForeign();
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }

    @Test
    public void shouldShowWrongMailAddress(){
        invoiceForeignPage_.markForeign()
                        .choosePrefix("CZ")
                        .enterNIP("55555555")
                        .enterCompanyName("Testowa")
                        .chooseCountry("Czechy")
                        .enterZipCode("30-135")
                        .enterTown("Prague")
                        .enterStreetName("Torfowa")
                        .buildingDetails("12","23")
                        .enterEmail("testtest.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL", invoiceForeignPage_.getErrorMassage());
    }
    @Test
    public void shouldShowMissingNipMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterCompanyName("Testowa")
                .chooseCountry("Czechy")
                .enterZipCode("30-135")
                .enterTown("Prague")
                .enterStreetName("Torfowa")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }
    @Test
    public void shouldShowMissingCompanyMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .chooseCountry("Czechy")
                .enterZipCode("30-135")
                .enterTown("Prague")
                .enterStreetName("Torfowa")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }

    @Test
    public void shouldShowMissingCountryMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterNIP("55555555")
                .enterCompanyName("Testowa")
                .enterZipCode("30-135")
                .enterTown("Prague")
                .enterStreetName("Torfowa")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }
    @Test
    @DisplayName("Given that information is missing, the site should show adequate massage")
    public void shouldShowMissingZipCodeMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterNIP("55555555")
                .enterCompanyName("Testowa")
                .chooseCountry("Czechy")
                .enterTown("Prague")
                .enterStreetName("Torfowa")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }

    @Test
    @DisplayName("Given that information is missing, the site should show adequate massage")
    public void shouldShowMissingTownMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterNIP("55555555")
                .enterCompanyName("Testowa")
                .chooseCountry("Czechy")
                .enterZipCode("30-135")
                .enterStreetName("Torfowa")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }
    @Test
    @DisplayName("Given that information is missing, the site should show adequate massage")
    public void shouldShowMissingStreetMassage(){
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterNIP("55555555")
                .enterCompanyName("Testowa")
                .chooseCountry("Czechy")
                .enterZipCode("30-135")
                .enterTown("Prague")
                .buildingDetails("12","23")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }
    @Test
    @DisplayName("Given that information is missing, the site should show adequate massage")
    public void shouldShowMissingBuildingInfoMassage() {
        invoiceForeignPage_.markForeign()
                .choosePrefix("CZ")
                .enterNIP("55555555")
                .enterCompanyName("Testowa")
                .chooseCountry("Czechy")
                .enterZipCode("30-135")
                .enterTown("Prague")
                .enterStreetName("Torfowa")
                .enterEmail("test@test.pl");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceForeignPage_.getErrorMassage());
    }


 }






