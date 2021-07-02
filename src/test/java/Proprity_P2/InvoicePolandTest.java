package Proprity_P2;

import Helper.WaitPage;
import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class InvoicePolandTest extends Base {

    SummaryPage summaryPage = new SummaryPage();
    SenderPage senderPage = new SenderPage();
    RecipientPage recipientPage = new RecipientPage();
    InvoicePolandPage invoicePolandPage = new InvoicePolandPage();
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
        }catch(Exception ignored){}

    }

    @Test
    @DisplayName("Given incorrect nip number, there should be adequate massage")
    public void shouldShowIncorrectNIP(){
        invoicePolandPage.markPolishCompany()
                        .enterNIP("dfsdgsdgasg")
                        .enterCompanyName("Inpost");
        assertEquals("PODANY NUMER NIP JEST NIEPRAWIDŁOWY",invoicePolandPage.getErrorMassage());

    }


    @Test
    @DisplayName("Given that correct NIP number was provided, the site should auto complete rest of text fields")
    public void shouldFillTheRestOfPage() throws InterruptedException {
        invoicePolandPage.markPolishCompany()
                .enterNIP("6793087624");
        TimeUnit.SECONDS.sleep(5);
        agreementPage.markTerms().goToSummary();
        assertEquals("Podsumowanie",summaryPage.getTitle());
    }

    @Test
    @DisplayName("Given that user marks invoice, it's required that he fill the page")
    public void shouldRequireData(){
        invoicePolandPage.markPolishCompany();
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",invoicePolandPage.getErrorMassage());
    }

    @Test
    @DisplayName("Given wrong mail address there should be adequate massage")
    public void shouldShowWrongMailAddress() throws InterruptedException {
        invoicePolandPage.markPolishCompany()
                .enterNIP("6793087624");
        TimeUnit.SECONDS.sleep(5);
        invoicePolandPage.mailAddress.clear();
        invoicePolandPage.enterMail("test.pl");
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL",invoicePolandPage.getErrorMassage());
    }




}
