package in.redbus.testClasses;

import in.redbus.base.BaseTest;
import in.redbus.pages.HelpsPagePO;
import in.redbus.pages.HomePagePO;
import org.testng.annotations.Test;

public class HelpsPageTest extends BaseTest {
    HomePagePO homePagePO = new HomePagePO();
    HelpsPagePO helpsPagePO = new HelpsPagePO();

    @Test(priority = 2, enabled = true,groups = "smoke",description = "Validate Helps Page")
    public void validateHelpsBoxTitleAndsubtitle() {
        homePagePO.clickOnHelps();
        homePagePO.switchDriverToNextPage();
        helpsPagePO.validateHelpsBoxTitleAndsubtitle();
        helpsPagePO.swichToDefaultPage();
    }

    @Test(priority = 1,groups = {"Smoke"}, description = "Validate Helps Page Title")
    public void validatehelpPageTitle() {
        homePagePO.clickOnHelps();
        homePagePO.switchDriverToNextPage();
        helpsPagePO.validateHelpsPageTitle();
        helpsPagePO.swichToDefaultPage();
    }


}
