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
     * Runs a simple test verifying link to the search page
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifySearchLinkTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        // initialize page object
        AddressIndexPage gpage = PageFactory.initElements(driver, AddressIndexPage.class);
        gpage.visitPage();
        gpage.followLink();
        AddressIndexSearch apage = PageFactory.initElements(driver, AddressIndexSearch.class);
        try {
            Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        assertEquals(apage.title, apage.getTitle(driver));
    }
}
