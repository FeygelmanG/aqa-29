package io.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class WebStepDefinitions {

    @Given("unathorized user opened the site")
    public void openUrl() throws MalformedURLException {
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(), options
        );
        setWebDriver(remoteWebDriver);

        Configuration.baseUrl = "https://podberi-sobaku.ru";
        //Configuration.pageLoadStrategy= "eager";
        open("/");
    }

    @Given("opens the page \"Собаки в добрые руки\"")
    public void openPage() {
        open("/sobaki-v-dobrie-ruki");
    }

    @When("choose size filter option")
    public void chooseSize() {
        $("[for='pt-ff_razmer-kroshechnaya']").click();
    }

    @Then("search results are updated")
    public void checkSearchResults() {
        $("#pt-adverts-spinner").shouldNotBe(Condition.visible);
    }

    @Then("the filter by size is displayed in the list of the selected filters")
    public void checkSearchFilters() {
        $("#pt-filter-results [data-alias='ff_razmer']")
                .shouldHave(Condition.attribute("data-value", "kroshechnaya"));
    }
}
