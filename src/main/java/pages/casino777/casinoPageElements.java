package pages.casino777;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class casinoPageElements {

    casinoPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private final String DROP_DOWN_MENU = "//*[@id=\"header\"]/div[2]/div[2]/div[1]/a";
    private final String REGISTER_BUTTON = "reg";
    private final String LANGUAGE_LIST_CONTAINER = "lang";
    private final String ENGLISH_LANGUAGE_DROPDOWN_ITEM = "lang_en";
    private final String RUSSIAN_LANGUAGE_DROPDOWN_ITEM = "lang_ru";
    private final String LATVIAN_LANGUAGE_DROPDOWN_ITEM = "lang_lv";

    @FindBy(xpath = DROP_DOWN_MENU)
    WebElement languagesSelectButton;

    @FindBy(className = LANGUAGE_LIST_CONTAINER)
    WebElement languagesListContainer;

    @FindBy(className = REGISTER_BUTTON)
    WebElement registerButton;

    @FindBy(className = ENGLISH_LANGUAGE_DROPDOWN_ITEM)
    WebElement englishLanguageDropDownItem;

    @FindBy(className = RUSSIAN_LANGUAGE_DROPDOWN_ITEM)
    WebElement russianLanguageDropDownItem;

    @FindBy(className = LATVIAN_LANGUAGE_DROPDOWN_ITEM)
    WebElement latvianLanguageDropDownItem;
}
