package in.redbus.testClasses;


import in.redbus.base.BaseTest;
import in.redbus.pages.HomePagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    HomePagePO homePagePO = new HomePagePO();



    @Test(priority = 1, description = "validate Home PageHeader Elements",groups = {"smoke"})
    public void validateHomePageHeaderElements() {
        test.info("Validating Home Page Header Elements");
        homePagePO.validateHomepageHeaderElements();
        test.info("Validated Home Page Header Elements");
        log.info("Validated Home Page Header Elements Successfully...");
    }

//    @Test(priority = 2, description = "validate Account Options",groups = {"regression"})
//    public void validateAccountOptions() {
//        test.info("Validating Account Options");
//        homePagePO.validateAccountOptions();
//        test.info("Validated Account Options");
//        log.info("Validated Account Options Successfully...");
//    }

}
