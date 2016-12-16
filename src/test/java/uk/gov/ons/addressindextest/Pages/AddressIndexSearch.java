package uk.gov.ons.addressindextest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressIndexSearch extends PageBase {

    public AddressIndexSearch(WebDriver driver) {
        this.driver = driver;
    }

    public String title = "Address index demo - Find an address";

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "address")
    private WebElement searchTextAreaInput;

    @FindBy(tagName = "h3")
    private WebElement resultsSpan;

    public void submitSearchText(String text) {
        setTextAreaInputValue(this.searchTextAreaInput, text);
        clickButton(this.submitButton);

        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(resultsSpan, text));
    }

    public String getResultsText() {
        return this.resultsSpan.getText();
    }
}
