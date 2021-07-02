package Proprity_P2;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class InvoiceIndividualTest extends Base {
    SummaryPage summaryPage = new SummaryPage();
    SenderPage senderPage = new SenderPage();
    RecipientPage recipientPage = new RecipientPage();
    InvoiceIndividualPage invoiceIndividualPage = new InvoiceIndividualPage();
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
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();


    }


    @Test
    @DisplayName("Given that we enter correct data, the site should allow to go to summary")
    public void shouldFillAllInformation() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .enterName("Michal Tomczyk")
                .enterMailAddress("mitomczyk@test.pl")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielcka")
                .apartmentDetails("28", "b");
        agreementPage.markTerms().goToSummary();
        assertEquals("Podsumowanie", summaryPage.getTitle());
    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldCopyRecipientData() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .copySenderInformation();
        TimeUnit.SECONDS.sleep(1);
        invoiceIndividualPage.enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .apartmentDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("Podsumowanie", summaryPage.getTitle());
    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldShowMissingMail() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .enterName("Michał Tomczyk")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .apartmentDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceIndividualPage.getErrorMassage());
    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldShowMissingZipCode() {
        invoiceIndividualPage.markIndividual()
                .enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyk@inpost.pl")
                .apartmentDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceIndividualPage.getErrorMassage());
    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldShowMissingTown() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyk@inpost.pl")
                .enterZipCode("30-135")
                .apartmentDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceIndividualPage.getErrorMassage());

    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldShowMissingStreet() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyk@inpost.pl")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .apartmentDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", invoiceIndividualPage.getErrorMassage());

    }

    @Test
    @DisplayName("Given missing text field, the site should not allow to go to summary")
    public void shouldShowMissingBuildingNumber() throws InterruptedException{
          invoiceIndividualPage.markIndividual()
                 .enterName("Michał Tomczyk")
                 .enterMailAddress("mitomczyk@inpost.pl")
                 .enterZipCode("30-135")
                 .enterCity("Kraków")
                  .enterStreet("Wielicka");
          agreementPage.markTerms().goToSummary();
          assertEquals("POLE WYMAGANE", invoiceIndividualPage.getErrorMassage());

        }
    @Test
    @DisplayName("Given incorrect mail address there should be adequate massage")
    public void shouldShowWrongMailAddress() throws InterruptedException {
        invoiceIndividualPage.markIndividual()
                .enterName("Michal Tomczyk")
                .enterMailAddress("mitomczyktest.pl")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielcka")
                .apartmentDetails("28", "b");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL",invoiceIndividualPage.getErrorMassage());
    }
    }

