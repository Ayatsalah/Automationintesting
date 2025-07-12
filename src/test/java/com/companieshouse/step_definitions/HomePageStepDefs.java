package com.companieshouse.step_definitions;

import com.companieshouse.pages.HomePage;
import com.companieshouse.utilities.ConfigurationReader;
import com.companieshouse.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class HomePageStepDefs {

    HomePage homePage = new HomePage();

    @Given("the user on the home page")
    public void the_user_on_the_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }

    @Then("the user should see the following links")
    public void the_user_should_see_the_following_links(List<String> expectedLinks) {
        List<String> actualLinks = new ArrayList<>();
        for (WebElement each : homePage.links) {
            actualLinks.add(each.getText());
        }

        Assert.assertEquals(expectedLinks, actualLinks);

    }


    @Then("the user should see Book Now Button")
    public void theUserShouldSeeBookNowButton() {

        Assert.assertTrue(homePage.bookNowBtn.isDisplayed());


    }

    @And("the Book Now button is enabled")
    public void theBookNowButtonIsEnabled() {
        Assert.assertTrue(homePage.bookNowBtn.isEnabled());
    }


    @When("the user clicks on this {string}")
    public void theUserClicksOnThis(String link) {
        homePage.selectLink(link).click();
    }

    @Then("the {string} is clickable")
    public void theIsClickable(String link) {
        String expectedUrl;

        if (!link.equals("Admin")) {
            expectedUrl = "https://automationintesting.online/#" + link.toLowerCase();
        } else {
            expectedUrl = "https://automationintesting.online/" + link.toLowerCase();
        }

        String actualUrl = homePage.getTheTitle(link);
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @And("the Book Now button is clickable")
    public void theBookNowButtonIsClickable() {
        homePage.bookNowBtn.click();
        String expectedUrl = "https://automationintesting.online/#booking";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
