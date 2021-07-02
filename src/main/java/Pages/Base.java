package Pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\SOFT/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test-oneclick-pl.easypack24.net/SzybkieNadania/");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//button[@class='btn-cookie-trigger']")).click();
    }

   @AfterClass
   public static void tearDown() {
       driver.quit();
  }






}
