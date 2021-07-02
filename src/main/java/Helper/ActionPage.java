package Helper;

import Pages.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ActionPage {



    private Actions actions = new Actions(Base.driver);

    public void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void cookies(){
        WebElement cookie = Base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));

        actions.click(cookie);
    }
}
