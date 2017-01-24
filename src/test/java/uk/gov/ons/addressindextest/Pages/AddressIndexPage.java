package uk.gov.ons.addressindextest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressIndexPage extends PageBase {

    @FindBy(linkText = "Find an address")
    private WebElement theActiveLink;

    public AddressIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitPage() {
        driver.get("https://addressindex-ui.cfapps.io/");
    }

    public void followLink() {
        clickLink(this.theActiveLink);
    }
}
