package uk.gov.ons.addressindextest.Tests;

import uk.gov.ons.addressindextest.Pages.AddressIndexSearch;
import uk.gov.ons.addressindextest.Pages.AddressIndexPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import static org.junit.Assert.assertEquals;

public class AddressIndexTestFollowLinkTest extends AddressIndexTestBase {

    /**
     * Runs a simple test verifying the checked checkbox state
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyUncheckedCheckBoxInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        // initialize page object
        AddressIndexPage gpage = PageFactory.initElements(driver, AddressIndexPage.class);

        gpage.visitPage();
        gpage.followLink();

        AddressIndexSearch apage = PageFactory.initElements(driver, AddressIndexSearch.class);

        assertEquals(apage.title, apage.getTitle(driver));

    }

}
