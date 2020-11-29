package w3Schools;

import org.testng.annotations.Test;
import pages.w3schools.TablePageActions;
import data_providers.TableProvider;
import managers.BaseTest;
import utils.BrowserTypes;

public class TestRetrievingTableDataByCell extends BaseTest {

    public TestRetrievingTableDataByCell() {
        super(BrowserTypes.Chrome, "https://www.w3schools.com/html/html_tables.asp");
    }

    @Test(dataProvider = "Positive", dataProviderClass = TableProvider.class)
    void getTableContentPositive(int searchColumn, String searchText, int returnColumnText) {
        TablePageActions actions = new TablePageActions(getDriver());
        System.out.println(actions.getTableCellText(actions.customersTable, searchColumn, searchText, returnColumnText));
    }

    @Test(dataProvider = "Negative", dataProviderClass = TableProvider.class)
    void getTableContentNegative(int searchColumn, String searchText, int returnColumnText) {
        TablePageActions actions = new TablePageActions(getDriver());
        System.out.println(actions.getTableCellText(actions.customersTable, searchColumn, searchText, returnColumnText));
    }

    @Test(dataProvider = "Positive1", dataProviderClass = TableProvider.class)
    void verifyTableCellContentPositive(int searchColumn, String searchText, int returnColumnText, String expectedText) {
        TablePageActions actions = new TablePageActions(getDriver());
        System.out.println(actions.verifyTableCellText(actions.customersTable, searchColumn, searchText, returnColumnText, expectedText));
    }

    @Test(dataProvider = "Negative1", dataProviderClass = TableProvider.class)
    void verifyTableCellContentNegative(int searchColumn, String searchText, int returnColumnText, String expectedText) {
        TablePageActions actions = new TablePageActions(getDriver());
        System.out.println(actions.verifyTableCellText(actions.customersTable, searchColumn, searchText, returnColumnText, expectedText));
    }

    @Test()
    void getTableContentByXpath() throws Exception {
        TablePageActions actions = new TablePageActions(getDriver());
        System.out.println(actions.getTableCellTextByXpath(actions.customersTable, 0, "Helen Bennett", 3));
    }
}
