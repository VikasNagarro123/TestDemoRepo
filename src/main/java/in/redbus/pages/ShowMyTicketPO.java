package in.redbus.pages;

import in.redbus.Elements.ShowMyTicketElement;
import in.redbus.utilities.ElementEnteractions;
import in.redbus.utilities.FetchElelements;

public class ShowMyTicketPO extends ElementEnteractions {
    FetchElelements fetchElelements = new FetchElelements();
    public void enterTicketNumber(String ticketNumber) {
        onSendKeys(fetchElelements.getElement("xpath", ShowMyTicketElement.tiketNumberFieldLocator), ticketNumber);
    }

    public void enterMobileNumber(String mobileNumber) {
        onSendKeys(fetchElelements.getElement("id", ShowMyTicketElement.mobileNumberFieldLocator), mobileNumber);
    }

    public void clickSubmitButton() {
        onClick(fetchElelements.getElement("id", ShowMyTicketElement.submitButtonLocator));
    }
}
