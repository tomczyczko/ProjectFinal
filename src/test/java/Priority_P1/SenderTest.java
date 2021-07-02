package Priority_P1;

import Pages.AgreementPage;
import Pages.Base;
import Pages.RecipientPage;
import Pages.SenderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


public class SenderTest extends Base {

    RecipientPage recipientPage = new RecipientPage();
    SenderPage senderPage = new SenderPage();
    AgreementPage agreementPage = new AgreementPage();

    @Before
    public void fillRecipientPage() throws InterruptedException {
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("test@test.pl")
                .enterPhoneNumber("737878829")
                .enterParcelLocation("Kraków Wielicka 28");
    }

    @After
    public void refresh(){
        Base.driver.navigate().refresh();
        try {
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        }catch(Exception ignored){}    }



    @Test
    @DisplayName("Given that we don't include name, there should be adequate massage on page")
    public void shouldShowMissingName() throws InterruptedException {
        senderPage.enterMailAddress("mitomczyk@test.pl")
                    .enterPhoneNumber("123456789");
        agreementPage.markTerms()
                    .goToSummary();
        assertEquals("POLE WYMAGANE", senderPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given that we don't include mail address, there should be adequate massage on page")
    public void shouldShowMissingMailAddres() throws InterruptedException {

        senderPage.enterName("Michał Tomczyk")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms()
                .goToSummary();
        assertEquals("POLE WYMAGANE", senderPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given that we don't include phone number, there should be adequate massage on page")
    public void shouldShowMissingPhoneNumber() throws InterruptedException {

        senderPage.enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyk@test.pl");
        agreementPage.markTerms()
                .goToSummary();
        assertEquals("POLE WYMAGANE", senderPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given that we include incorrect mail address, there should be adequate massage on page")
    public void shouldShowWrongMailAddress() throws InterruptedException {

        senderPage.enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyktest.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms()
                .goToSummary();
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL", senderPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given that we 't include incorrect phone number, there should be adequate massage on page")
    public void shouldShowWrongPhoneNumber() throws InterruptedException {

        senderPage.enterName("Michał Tomczyk")
                .enterMailAddress("mitomczyk@test.pl")
                .enterPhoneNumber("1111111111111");
        agreementPage.markTerms()
                .goToSummary();
        assertEquals("NIEPRAWIDŁOWY NUMER TELEFONU", senderPage.getMissingInformationMassage());
    }

}
