package data_providers;

import org.testng.annotations.DataProvider;

public class MailProvider {

    @DataProvider(name = "Mail Credentials")
    Object[][] mailCredentials() {
        return new Object[][] {
                {"" , ""}
        };
    }
}
