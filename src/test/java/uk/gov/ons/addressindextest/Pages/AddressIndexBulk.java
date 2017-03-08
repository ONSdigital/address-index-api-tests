package uk.gov.ons.addressindextest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressIndexBulk extends PageBase {

    public AddressIndexBulk(WebDriver driver) {
        this.driver = driver;
    }
    
    public void visitPage() {
        driver.get("https://addressindex-ui.eu-gb.mybluemix.net/bulkAddresses");
    }

    public String title = "Address index demo - Find an address";

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    @FindBy(name = "file")
    private WebElement fileButton;

    @FindBy(xpath = "//input[@type='submit'")
    private WebElement uploadButton;

    @FindBy(className = "green")
    private WebElement resultsSpan;

    public void submitBuik() {
        fileButton.clear();
        fileButton.sendKeys("addresses.csv");
        clickButton(this.uploadButton);
    }

    public String getResultsText() {
        return this.resultsSpan.getText();
    }
}
