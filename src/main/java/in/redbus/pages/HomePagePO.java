package in.redbus.pages;

import in.redbus.Elements.HomePageElement;
import in.redbus.base.BaseTest;
import in.redbus.utilities.ElementEnteractions;
import in.redbus.utilities.FetchElelements;
import in.redbus.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePagePO extends ElementEnteractions {
    FetchElelements fetchElelements = new FetchElelements();
    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(Integer.parseInt(Utility.getProperties("ExplicitWaitTime"))));


    public void validateHomepageHeaderElements() {
       SoftAssert softAssert=new SoftAssert();
      WebElement element= wait.until(ExpectedConditions.visibilityOf(fetchElelements.getElement("cssSelector", HomePageElement.logo)));
        softAssert.assertTrue(element.isDisplayed(),"Logo is not displayed");
        softAssert.assertEquals(BaseTest.driver.getTitle(),"Bus Ticket Booking Online at Cheapest Price with Top Bus Operators- redBus","Title is not matching");
        softAssert.assertTrue(fetchElelements.getElement("id", HomePageElement.railBookingBox).isDisplayed(),"Rail Booking Box is not displayed");
        softAssert.assertTrue(fetchElelements.getElement("id", HomePageElement.busTicketsBox).isDisplayed(),"Bus Tickets Box is not displayed");
        softAssert.assertTrue(fetchElelements.getElement("id", HomePageElement.helpCareBox).isDisplayed(),"Help Care Box is not displayed" );
        softAssert.assertTrue(fetchElelements.getElement("cssSelector", HomePageElement.accountDropdown).isDisplayed(),"Account Dropdown is not displayed");
        softAssert.assertAll();
        BaseTest.log.info("Validated Home Page Header Elements");
    }

    public void validateAccountOptions(){
        onClick(fetchElelements.getElement("cssSelector", HomePageElement.accountDropdown));
        BaseTest.log.info("Clicked on Account Dropdown");
        List<WebElement> listOfElements=wait.until(ExpectedConditions.visibilityOfAllElements(fetchElelements.getListOfElements("xpath", HomePageElement.accountOptionsList)));
        List<String> expectedAccountOptions=new ArrayList<>();
        for(WebElement ele:listOfElements){
            expectedAccountOptions.add(ele.getText());
        }
        Assert.assertEquals(HomePageElement.ActualAccountOptions,expectedAccountOptions,"Account Options is not matching");
        BaseTest.log.info("Validated Account Options");
    }

    public void clickOnTrainTicketBox(){
        onClick(fetchElelements.getElement("id", HomePageElement.railBookingBox));
        BaseTest.log.info("Clicked on Train Ticket Box");
    }

    public void clickOnHelps() {
        onClick(fetchElelements.getElement("id", HomePageElement.helpCareBox));
        BaseTest.log.info("Clicked on Helps");
    }
    public void switchDriverToNextPage(){
        swichToNextPage();
    }

    public void clickAccountOption(String printTicketOption) {
        onClick(fetchElelements.getElement("cssSelector", HomePageElement.accountDropdown));
        WebElement showMyTicketOption=wait.until(ExpectedConditions.visibilityOf(BaseTest.driver.findElement(By.xpath("//ul[@class='header_dropdown_menu']/li/span[normalize-space()='"+printTicketOption+"']") )));
        onClick(showMyTicketOption);
    }
}
