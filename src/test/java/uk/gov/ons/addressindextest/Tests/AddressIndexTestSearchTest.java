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

public class AddressIndexTestTextInputTest extends AddressIndexTestBase {

    /**
     * Runs a simple test verifying the search input is functional.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifySearchInputTest(String browser, String version, String os, Method method)
    throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        String[][] uprns = {
            {
                "100040239491",
                "Flat F 27 Well Street"
            },
            {
                "10013046138",
                "Flat 2 125a Fre Street EX4 3JQ"
            },
            {
                "10013046200",
                "Apartment 23 Bedford House 14 Bedford Street EX1 1LR"
            },
            {
                "100041142491",
                "flat 21 montpelier court st davids hill exeter devon ex4 4dp"
            },
            {
                "100041142491",
                "flat 21 montplier court st. david's hill exeter ex4 4da"
            },
            {
                "10013048119",
                "1 The Court 122  Fore Street EX4"
            },
            {
                "100041131820",
                "Flat 3 Crescent Mansion Mount Radfrd Crescent Exeter EX2 4ER"
            },
            {
                "10023117515",
                "Flat 2 Shirehampton House 35 - 37 St Davids Hill  Exeter EX4 4FJ"
            },
            {
                "10023122007",
                "Flat 1 156 Pihoe Road EX4"
            },
            {
                "100040202965",
                "Honeywood Belvidere Road Exeter"
            },
            {
                "10013050229",
                "31, Constantine House, New North Road, Exeter, Devon EX4 4JH"
            },
            {
                "10013046647",
                "17 Augustus House New North Road Exeter EX4 4HL I"
            },
            {
                "10091470005",
                "Lyndhurst Streatham Rise"
            },
            {
                "100040217442",
                "Trevecka Higher Hoopern Lane Exeter Devon EX4 4SQ"
            },
            {
                "10023121725",
                "Ground Floor Flat 21 Park Road Exeter EX1 2SH"
            },
            {
                "10013045985",
                "FLAT 1ST FLOOR 4 ST JAMES ROAD EXETER EX4"
            },
            {
                "10013038967",
                "Garden Flat 54 Pinhoe Road Exeter EX4"
            },
            {
                "10013041009",
                "BLUE ARROW PORTLAND HOUSE EXETER"
            },
            {
                "10013042137",
                "Flat 1b Angel Pavement 145 - 147 For Street EX4 3AN"
            },
            {
                "100040212515",
                "211a exwick road exeter ex42au"
            },
            {
                "100040233649",
                "152c sidwell street ex46rt"
            },
            {
                "100040234036",
                "48c South Street EX11EE"
            },
            {
                "100040234435",
                "19 st andrews road ex4 2aa"
            },
            {
                "100041045362",
                "3 Wynards EX2 4HX"
            }
        };

        for (Iterator < string > i = uprns.iterator(); i.hasNext();) {
            String searchInputText = i.next()[1];
            String uprn = i[0];

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
}
