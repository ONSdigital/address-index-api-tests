package uk.gov.ons.addressindextest.Tests;

import uk.gov.ons.addressindextest.Pages.AddressIndexBulk;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AddressIndexTestBulkTest extends AddressIndexTestBase {

    /**
     * Runs a simple test verifying the search input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void bulkTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability("version", "7");
        capabilities.setCapability("platform", Platform.XP);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://addressindex-ui.cfapps.io/bulkAddresses:80/"), capabilities);
        driver.setFileDetector(new LocalFileDetector());
        
        // initialize page object
        AddressIndexBulk gpage = PageFactory.initElements(driver, AddressIndexBulk.class);
        gpage.visitPage();
        gpage.submitBuik();
        
        //WebElement myDynamicElement = (new WebDriverWait(driver, 3))
          //    .until(ExpectedConditions.presenceOfElementLocated(By.className("green")));
        //assertThat(myDynamicElement.getText(), containsString("found"));
    }
}
