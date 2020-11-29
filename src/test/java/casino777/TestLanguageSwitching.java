package casino777;

import org.testng.annotations.Test;
import pages.casino777.CasinoPageActions;
import managers.BaseTest;
import utils.BrowserTypes;

public class TestLanguageSwitching extends BaseTest {

    public TestLanguageSwitching() {
        super(BrowserTypes.Chrome, "https://casino777.lv/en");
    }

    @Test
    void switchLanguages() {
        CasinoPageActions casinoActions = new CasinoPageActions(getDriver());
        casinoActions.switchBetweenAllAvailableLanguages();
    }
}
