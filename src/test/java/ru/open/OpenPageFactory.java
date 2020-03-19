package ru.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class OpenPageFactory {

    @FindBy(how = How.XPATH, using = "//input[@class='gLFyf gsfi']")
    private SelenideElement searchField;

    @FindBy(how = How.XPATH, using = "(//input[@value='Поиск в Google'])[1]")
    private SelenideElement searchButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class=\"TbwUpd NJjxre\"]//cite"))
    private ElementsCollection links;

    @FindAll(@FindBy(how = How.XPATH, using = "//h3[@class='LC20lb DKV0Md']"))
    private ElementsCollection searchOpen;

    @FindAll(@FindBy(how = How.XPATH, using = "//span[@class=\"main-page-exchange__rate\"]"))
    private ElementsCollection exchangeRates;

    public void searchText(String text) {
        element(searchField).setValue(text);
        element(searchButton).click();
    }

    public ElementsCollection getLinks() {
        return links;
    }

    public void goToOpenPage() {
        elements(searchOpen).find(text("Банк «Открытие» — вклады, кредитные и дебетовые ...")).click();
    }

    public ElementsCollection exchangeCheck() {
        ElementsCollection resultOfSearch = elements(exchangeRates);
        return resultOfSearch;
    }
}