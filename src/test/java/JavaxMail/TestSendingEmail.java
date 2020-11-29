package JavaxMail;

import org.testng.annotations.Test;
import data_providers.MailProvider;
import utils.JavaMailUtils;

public class TestSendingEmail {

    @Test(dataProvider = "Mail Credentials", dataProviderClass = MailProvider.class)
    void testSendingEmail(String username, String password) {
        JavaMailUtils mailUtils = new JavaMailUtils(username, password);
        mailUtils.sendMail(username, username, "Mail Test", "This is a test mail");
    }
}
