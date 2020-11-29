package managers;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapsManager extends DesiredCapabilities {

    protected ChromeOptions setChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return chromeOptions;
    }

    protected EdgeOptions setEdgeOptions() {
        return new EdgeOptions();
    }

    protected FirefoxOptions setFireFoxOptions() {
        return new FirefoxOptions();
    }
}
