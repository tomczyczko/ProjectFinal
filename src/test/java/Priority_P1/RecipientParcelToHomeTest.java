package Priority_P1;

import Pages.AgreementPage;
import Pages.Base;
import Pages.DeliveryTypePage;
import Pages.RecipientPage;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientParcelToHomeTest extends Base {

    DeliveryTypePage deliveryTypePage = new DeliveryTypePage();
    RecipientPage recipientPage = new RecipientPage();
    AgreementPage agreementPage = new AgreementPage();

    @After
    public void refresh(){
        Base.driver.navigate().refresh();
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
    }


    @Test
    @DisplayName("Given that we not include recipient name in recipient page, there should be suitable massage")
    public void shouldShowMissingName() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28","B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());

    }

    @Test
    @DisplayName("Given that we not include mail address in recipient page, there should be suitable massage")
    public void shouldShowMissingMailAddress() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28","B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE",recipientPage.getMissingInformationMassage());

    }

    @Test
    @DisplayName("Given that we not include phone number in recipient page, there should be suitable massage")
    public void shouldShowMissingPhoneNumber() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28", "B");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", recipientPage.getMissingInformationMassage());
    }




    @Test
    @DisplayName("Given that we not include zip code in recipient page, there should be suitable massage")
    public void shouldShowMissingZipCode(){
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", recipientPage.getMissingInformationMassage());
    }


    @Test
    @DisplayName("Given that we not include town in recipient page, there should be suitable massage")
    public void shouldShowMissingTown() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", recipientPage.getMissingInformationMassage());
    }


    @Test
    @DisplayName("Given that we not include town in recipient page, there should be suitable massage")
    public void shouldShowMissingStreet() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", recipientPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given that we not include town in recipient page, there should be suitable massage")
    public void shouldShowMissingBuilding() throws InterruptedException {
        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka");
        agreementPage.markTerms().goToSummary();
        assertEquals("POLE WYMAGANE", recipientPage.getMissingInformationMassage());
    }



    @Test
    @DisplayName("Given incorrect mail address, there should be adequate massage")
    public void shouldShowWrongMailAddress() throws InterruptedException {

        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyktest.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28","B");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY ADRES EMAIL", recipientPage.getMissingInformationMassage());
    }
    @Test
    @DisplayName("Given incorrect phone number, there should be adequate massage")
    public void shouldShowWrongPhoneNumber() throws InterruptedException {

        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("111111111111")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28","B");
        agreementPage.markTerms().goToSummary();
        assertEquals("NIEPRAWIDŁOWY NUMER TELEFONU", recipientPage.getMissingInformationMassage());
    }

    @Test
    @DisplayName("Given to long additional massage, there should be adequate massage")
    public void shouldShowWToLongAdditionalMassage() throws InterruptedException {

        deliveryTypePage.chooseParcelToHome();
        recipientPage.enterName("Michał Tomczyk")
                .enterMail("mitomczyk@test.pl")
                .enterPhoneNumber("123456789")
                .enterZipCode("30-135")
                .enterCity("Kraków")
                .enterStreet("Wielicka")
                .enterBuildingDetails("28","B")
                .enterAdditionalInformation("Ta wiadomość specjalnie jest za długa i mam nadzieję że pojawi się odpowiedni bląd");
        agreementPage.markTerms().goToSummary();
        assertEquals("TA WARTOŚĆ JEST ZBYT DŁUGA. POWINNA MIEĆ 36 ZNAKÓW LUB MNIEJ", recipientPage.getMissingInformationMassage());
    }


}
