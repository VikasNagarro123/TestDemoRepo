package in.redbus.pages;

import in.redbus.Elements.HelpsPageElement;
import in.redbus.base.BaseTest;
import in.redbus.utilities.ElementEnteractions;
import in.redbus.utilities.FetchElelements;
import org.testng.Assert;

public class HelpsPagePO extends ElementEnteractions {
   FetchElelements fetchElelements = new FetchElelements();

    public void validateHelpsBoxTitleAndsubtitle() {

        Assert.assertEquals(getText(fetchElelements.getElement("cssSelector",HelpsPageElement.titleLocator)), HelpsPageElement.titleText,"Title is not displayed");
        BaseTest.log.info("Title is validated successfully");
        Assert.assertEquals(getText(fetchElelements.getElement("cssSelector",HelpsPageElement.subTitlesLocator)), HelpsPageElement.subTitlesText,"SubTitle is not displayed");
        BaseTest.log.info("SubTitle is validated successfully");
    }

    public void validateHelpsPageTitle() {
        Assert.assertEquals(BaseTest.driver.getTitle(), HelpsPageElement.pageTitle, "Helps page is not displayed");
        BaseTest.log.info("Helps page is validated successfully");
    }
}
