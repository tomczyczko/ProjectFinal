package Proprity_P2;

import Pages.Base;
import Pages.RedirectPage;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class RedirectTest extends Base {

    RedirectPage redirectPage = new RedirectPage();

    @After
    public void refresh(){
        Base.driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

    }

    @Test
    @DisplayName("Should redirect to inpost.pl")
    public void shouldGoToInpostPage(){
        redirectPage.goToInpostPage();
        String page = Base.driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/",page);

    }

    @Test
    @DisplayName("Should redirect to guide on how to send package")
    public void shouldGoToHowToSendPackage(){
        redirectPage.goToHowToSendPackage();
        String massage = redirectPage.howToSendPackageGuide();
        assertEquals("Jak nadać paczkę?",massage);
    }

    @Test
    @DisplayName("Should redirect to guide on to how to pack ackage")
    public void shouldGoToHowToPackPackage() throws InterruptedException {
        redirectPage.goToHowToPackPackage();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/sites/default/files/docs/regulaminy/zasady-przygotowania-i-pakowania-przesylek-inpost-595.pdf",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("Should redirect to terms of use")
    public void shouldGoToTermsOFUse() throws InterruptedException {
        redirectPage.enterTermOfUse();
        TimeUnit.SECONDS.sleep(3);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/regulaminy",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("Should redirect to integer")
    public void shouldGoToInteger() throws InterruptedException {
        redirectPage.goToInteger();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://integer.pl/",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("should redirect to privacy policy")
    public void shouldGoToPrivacyPolicy() throws InterruptedException {
        redirectPage.goToPrivacyPolicy();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/polityka-prywatnosci",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("Should go to complaints")
    public void shouldGoToComplaints() throws InterruptedException {
        redirectPage.goToComplaints();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/kontakt/zloz-reklamacje",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("Should redirect to help page")
    public void shouldGoToHelp() throws InterruptedException {
        redirectPage.goToHelp();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/kontakt?fulltext=szybkie%20nadania",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    @DisplayName("Should redirect to contact page")
    public void shouldGoToContact() throws InterruptedException {
        redirectPage.goToContact();
        TimeUnit.SECONDS.sleep(5);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String page = driver.getCurrentUrl().toString();
        assertEquals("https://inpost.pl/kontakt",page);
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
