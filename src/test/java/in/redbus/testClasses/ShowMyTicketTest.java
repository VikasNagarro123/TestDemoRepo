package in.redbus.testClasses;

import in.redbus.base.BaseTest;
import in.redbus.pages.HomePagePO;
import in.redbus.pages.ShowMyTicketPO;
import in.redbus.utilities.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShowMyTicketTest extends BaseTest {

    HomePagePO homePagePO = new HomePagePO();
    ShowMyTicketPO showMyTicketPO = new ShowMyTicketPO();

    @Test(dataProvider = "showMyTicketData", priority = 1, description = "Show My Ticket")
    public void validateShowMYTicketPage(String ticketNumber, String mobileNumber) {
        System.out.println("ticketNumber: " + ticketNumber);
        System.out.println("mobileNumber: " + mobileNumber);
        homePagePO.clickAccountOption("Show My Ticket");
        homePagePO.switchDriverToNextPage();
        showMyTicketPO.enterTicketNumber(ticketNumber);
        showMyTicketPO.enterMobileNumber(mobileNumber);
        showMyTicketPO.clickSubmitButton();

    }


    @DataProvider(name = "showMyTicketData")
    public Object[][] getShowMyTicketData() {
        return Utility.getTestData("ShowMyTicket");
    }
}
