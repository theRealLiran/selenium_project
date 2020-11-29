package data_providers;

import org.testng.annotations.DataProvider;

public class TableProvider {

    @DataProvider(name = "Positive")
    Object[][] positiveParams() {
        return new Object[][]{
                {1, "Francisco Chang", 0}
        };
    }

    @DataProvider(name = "Negative")
    Object[][] negativeParams() {
        return new Object[][]{
                {1, "Italy", 0}
        };
    }

    @DataProvider(name = "Positive1")
    Object[][] positiveParams1() {
        return new Object[][]{
                {1, "Giovanni Rovelli", 2, "Italy"}
        };
    }

    @DataProvider(name = "Negative1")
    Object[][] negativeParams1() {
        return new Object[][]{
                {1, "Italy", 0, "Island Trading"}
        };
    }



}
