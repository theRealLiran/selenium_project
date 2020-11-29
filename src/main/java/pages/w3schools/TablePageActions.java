package pages.w3schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePageActions extends TablePageElements {
    public TablePageActions(WebDriver driver) {
        super(driver);
    }

    /**
     * This method receives the given arguments below, before iterating through the table's rows in order to locate a
     * Cell matching the given 'searchColumn' param it checks if the given arguments (searchColumn & returnColumnText)
     * are valid. Once found, it matches the Cell data with the given 'searchText' data. If equals, returns the Row's
     * cell data at the 'returnColumnText' index. If not equals, returns null.
     *
     * @param table            the WebElement referring to the Table element
     * @param searchColumn     is the Column we want to perform the search upon
     * @param searchText       is the Text we are searching along the given Column
     * @param returnColumnText is the Column indication we want to extract the data from
     * @return is the extracted text based on the 'returnColumnText' param
     */
    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> columns = table.findElements(By.tagName("th"));

        if (searchColumn >= columns.size() || returnColumnText >= columns.size()) {
            System.out.println("Desired searched column (" + searchColumn + ")  or Desired return column text (" + returnColumnText + ") is not valid, please select a value between 0 - " + (columns.size() - 1));
            // I would rather throw Exception instead of returning null just keep control
            // throw new RuntimeException("Desired searched column " + searchColumn + " is not valid, please select a value between 0 - " + (columns.size() - 1));
            return null;
        }

        for (int i = 1; i < rows.size(); i++) {
            WebElement searchedElementByColumn = rows.get(i).findElements(By.tagName("td")).get(searchColumn);
            if (searchedElementByColumn.getText().equals(searchText)) {
                return rows.get(i).findElements(By.tagName("td")).get(returnColumnText).getText();
            }
        }

        System.out.println("Desired searched text (" + searchText + ") does not exist in the searched column (" + searchColumn + ")");
        return null;
        // I would rather throw Exception instead of returning null just keep control
        // throw new RuntimeException("Desired searched text (" + searchText + ") does not exist in the searched column (" + searchColumn+ ")");
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        return getTableCellText(table, searchColumn, searchText, returnColumnText).equals(expectedText);
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        WebElement cellData;
        try {
            cellData = table.findElement(By.xpath("//*[contains(text(),'" + searchText + "')]//parent::tr//child::td[" + returnColumnText + "]"));
        } catch (Exception e) {
            throw new Exception("Could not locate element by the given xpath");
        }
        return cellData.getText();
    }

}
