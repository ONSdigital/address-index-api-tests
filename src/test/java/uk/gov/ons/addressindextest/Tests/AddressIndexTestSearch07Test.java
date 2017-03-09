package uk.gov.ons.addressindextest.Tests;

import uk.gov.ons.addressindextest.Pages.AddressIndexSearch;
import uk.gov.ons.addressindextest.Pages.AddressIndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AddressIndexTestSearch07Test extends AddressIndexTestBase {

    /**
     * Runs a simple test verifying the search input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifySearch07Test(String browser, String version, String os, Method method)
    throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        String uprn = "10023117515";
        String searchInputText = "Flat 2 Shirehampton House 35 - 37 St Davids Hill  Exeter EX4 4FJ";

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        // initialize page object
        AddressIndexSearch gpage = PageFactory.initElements(driver, AddressIndexSearch.class);
        gpage.visitPage();
        gpage.submitSearchText(searchInputText);

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.className("uprn-txt")));
        assertThat(myDynamicElement.getText(), containsString(uprn));
    }
}