package managers;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.BrowserTypes;
import utils.TestListener;

@Listeners(TestListener.class)

public class BaseTest extends DriverManager {

    public BaseTest(BrowserTypes browser, String url) {
        super(new DesiredCapsManager());
        this.browser = browser;
        this.url = url;
    }

    private final BrowserTypes browser;
    private final String url;

    @BeforeTest
    public void initTest() {
        setUp(url, browser);
    }

    @AfterTest
    public void endTest() {
        tearDown();
    }

}
