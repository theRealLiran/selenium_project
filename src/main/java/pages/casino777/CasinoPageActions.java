package pages.casino777;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasinoPageActions extends casinoPageElements {

    enum Languages {
        RUSSIAN, LATVIAN, ENGLISH
    }

    public CasinoPageActions(WebDriver driver) {
        super(driver);
    }

    private WebElement getSelectedLanguageElement(Languages language) {
        switch (language) {
            case RUSSIAN:
                return russianLanguageDropDownItem;
            case LATVIAN:
                return latvianLanguageDropDownItem;
            case ENGLISH:
                return englishLanguageDropDownItem;
            default:
                throw new RuntimeException("Desired languages is not defined in scope");
        }
    }

    private void printAllAvailableLanguages() {
        languagesListContainer.findElements(By.className("item")).forEach(element -> System.out.println(element.getText()));
    }

    public void tapOnLanguageButton() {
        languagesSelectButton.click();
    }

    public void selectLanguageFromDropDownMenu(Languages language) {
        printAllAvailableLanguages();
        System.out.println("Selected Language : " + language);
        getSelectedLanguageElement(language).click();
    }

    public void validateCorrectLanguageSelected(Languages language) {
        System.out.println("Actual text from element : " + registerButton.getText());
        switch (language) {
            case RUSSIAN:
                assert registerButton.getText().equals("РЕГИСТРАЦИЯ");
            case LATVIAN:
                assert registerButton.getText().equals("REĢISTRĀCIJA");
            case ENGLISH:
                assert registerButton.getText().equals("REGISTRATION");
            default:
                throw new RuntimeException("Desired languages is not defined in scope");
        }
    }

    public void switchBetweenAllAvailableLanguages() {
        for (int i = 0; i < languagesListContainer.findElements(By.className("item")).size(); i++) {
            tapOnLanguageButton();
            selectLanguageFromDropDownMenu(Languages.values()[i]);
            validateCorrectLanguageSelected(Languages.values()[i]);
        }
    }
}
