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
        driver.get("http://addressindex-ui.cfapps.io/bulkUpload");
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

    public void submitSearchText(String text) {
        setTextAreaInputValue(this.searchTextAreaInput, text);
        clickButton(this.submitButton);
    }

    public String getResultsText() {
        return this.resultsSpan.getText();
    }
}
