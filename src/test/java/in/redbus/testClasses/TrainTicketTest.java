package in.redbus.testClasses;


import in.redbus.base.BaseTest;
import in.redbus.pages.HomePagePO;
import in.redbus.pages.TrainTicketPO;
import in.redbus.utilities.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrainTicketTest extends BaseTest{
    HomePagePO homePagePO = new HomePagePO();
    TrainTicketPO trainTicketPO = new TrainTicketPO();

//    @Test(dataProvider = "getTrainTicketData") // This is the data provider method name
    @Test(dataProvider = "dataName",groups = {"regression"}, description = "Validate Train Ticket Page")
    public void validateTrainTicketPage(String source, String destination) {
        homePagePO.clickOnTrainTicketBox();
        trainTicketPO.enterSource(source);
        trainTicketPO.enterDestination(destination);
        trainTicketPO.clickOnSearchButton();
    }

    @DataProvider(name="dataName")
    public Object[][] getTrainTicketData() {
        Object[][] data = Utility.getTestData("TrainTicket");
        return data;
    }
}
