package in.redbus.pages;

import in.redbus.Elements.TrainTicketElement;
import in.redbus.base.BaseTest;
import in.redbus.utilities.ElementEnteractions;
import in.redbus.utilities.FetchElelements;
import in.redbus.utilities.Utility;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainTicketPO extends ElementEnteractions {

    FetchElelements fetchElelements = new FetchElelements();
    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(Integer.parseInt(Utility.getProperties("ExplicitWaitTime"))));


    public void enterSource(String source) {
        BaseTest.log.info("Entering source as: " + source);
        onSendKeys(fetchElelements.getElement("id", TrainTicketElement.source), source);
    }

    public void enterDestination(String destination) {
        BaseTest.log.info("Entering destination as: " + destination);
        onSendKeys(fetchElelements.getElement("id", TrainTicketElement.destination), destination);
    }


    public void clickOnSearchButton() {
        BaseTest.log.info("Clicking on search button");
        onClick(fetchElelements.getElement("xpath", TrainTicketElement.searchButton));
    }
}
