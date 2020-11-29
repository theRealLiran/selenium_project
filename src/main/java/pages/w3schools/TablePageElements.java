package pages.w3schools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePageElements {

    TablePageElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    private final String CUSTOMERS_TABLE = "customers";
    private final String HTML_TABLE = "w3-table-all notranslate";

    @FindBy(id = CUSTOMERS_TABLE)
    public WebElement customersTable;

    @FindBy(className = HTML_TABLE)
    public WebElement htmlTable;


}
