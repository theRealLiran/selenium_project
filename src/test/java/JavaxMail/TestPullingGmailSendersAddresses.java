package JavaxMail;

import org.testng.annotations.Test;
import data_providers.MailProvider;
import utils.JavaMailUtils;

import javax.mail.MessagingException;

public class TestPullingGmailSendersAddresses {

    @Test(dataProvider = "Mail Credentials", dataProviderClass = MailProvider.class)
    void testGettingUserMailSenders(String username, String password) throws MessagingException {
        JavaMailUtils javaMailUtils = new JavaMailUtils(username, password);
        javaMailUtils.retrieveEmailFromGmail();
    }

}
