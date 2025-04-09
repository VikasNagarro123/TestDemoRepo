package in.redbus.utilities;

import in.redbus.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FetchElelements {

    public WebElement getElement(String type, String value){
        switch (type){
            case "id":
                return BaseTest.driver.findElement(By.id(value));
            case "name":
                return BaseTest.driver.findElement(By.name(value));
            case "xpath":
                return BaseTest.driver.findElement(By.xpath(value));
            case "className":
                return BaseTest.driver.findElement(By.className(value));
            case "linkText":
                return BaseTest.driver.findElement(By.linkText(value));
            case "partialLinkText":
                return BaseTest.driver.findElement(By.partialLinkText(value));
            case "tagName":
                return BaseTest.driver.findElement(By.tagName(value));
            case "cssSelector":
                return BaseTest.driver.findElement(By.cssSelector(value));
            default:
                System.err.println("Invalid locator type");
                return null;
        }
    }

    public List<WebElement> getListOfElements(String type, String value){

        switch (type){
            case "id":
                return BaseTest.driver.findElements(By.id(value));
            case "name":
                return BaseTest.driver.findElements(By.name(value));
            case "xpath":
                return BaseTest.driver.findElements(By.xpath(value));
            case "className":
                return BaseTest.driver.findElements(By.className(value));
            case "linkText":
                return BaseTest.driver.findElements(By.linkText(value));
            case "partialLinkText":
                return BaseTest.driver.findElements(By.partialLinkText(value));
            case "tagName":
                return BaseTest.driver.findElements(By.tagName(value));
            case "cssSelector":
                return BaseTest.driver.findElements(By.cssSelector(value));
            default:
                System.err.println("Invalid locator type");
                return null;
        }
    }
}
