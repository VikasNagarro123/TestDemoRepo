package in.redbus.utilities;

import in.redbus.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;


public class ElementEnteractions {

    public void onClick(WebElement element) {
        try {
            element.click();
            BaseTest.log.info("Clicked on element");
        }catch (Exception e){
            Actions action = new Actions(BaseTest.driver);
            action.moveToElement(element).click().build().perform();
            BaseTest.log.error("Element is not clickable by .click method, used Actions class to click on element");
        }
    }

    public void clickUsingJavaScript(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].click();",element);
        BaseTest.log.info("Clicked on element using JavaScript");
    }

    public void onSendKeys(WebElement element, String text){
        element.sendKeys(text);
        BaseTest.log.info("Entered text in element");
    }

    public void clear(WebElement element){
        element.clear();
        BaseTest.log.info("Cleared text in element");
    }

    public void swichToNextPage(){
      Set<String> pageNumber=BaseTest.driver.getWindowHandles();
       for(String window:pageNumber){
           BaseTest.driver.switchTo().window(window);
       }
    }

    public void swichToDefaultPage(){
        BaseTest.driver.switchTo().defaultContent();
    }

    public String getText(WebElement element){
        return element.getText();
    }
}
