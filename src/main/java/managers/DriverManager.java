package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.BrowserTypes;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public DriverManager(DesiredCapsManager desiredCaps) {
        this.desiredCaps = desiredCaps;
    }

    private WebDriver driver;
    private final DesiredCapsManager desiredCaps;

    public WebDriver getDriver() {
        return driver;
    }

    public void setUp(String url, BrowserTypes browser) {
        switch (browser) {
            case Chrome:
                driver = new ChromeDriver(desiredCaps.setChromeOptions());
                break;
            case Microsoft_Edge:
                driver = new EdgeDriver(desiredCaps.setEdgeOptions());
                break;
            case FireFox:
                driver = new FirefoxDriver(desiredCaps.setFireFoxOptions());
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
