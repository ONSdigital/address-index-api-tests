package uk.gov.ons.addressindextest.Tests;


import uk.gov.ons.addressindextest.Pages.AddressIndexPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AddressIndexTextInputTest extends SampleSauceTestBase {

    /**
     * Runs a simple test verifying if the email input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifyEmailInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
        String searchInputText = "7 Gate Reach Exeter EX2 6GA";

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        // initialize page object
        AddressIndexSearch gpage = PageFactory.initElements(driver, AddressIndexSearch.class);

        gpage.visitPage();

        gpage.submitSearchText(searchInputText);

        assertThat(gpage.getSubmittedCommentText(), containsString(searchInputText));


    }

}
