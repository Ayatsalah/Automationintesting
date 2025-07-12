package com.companieshouse.step_definitions;

import com.companieshouse.pages.ContactPage;
import com.companieshouse.pages.HomePage;
import com.companieshouse.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class ContactStepDefs {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("the user clicks on the contact link")
    public void the_user_clicks_on_the_contact_link() {
        homePage.contactLink.click();

    }

    @When("the user fills the following information {string},{string},{string},{string} and {string}")
    public void the_user_fills_the_following_information_and(String name, String email, String phone, String subject, String message) {
        contactPage.nameInput.sendKeys(name);
        contactPage.emailInput.sendKeys(email);
        contactPage.phoneInput.sendKeys(phone);
        contactPage.subjectInput.sendKeys(subject);

        contactPage.messageInput.sendKeys(message);


    }

    @When("the user clicks on the Submit button")
    public void the_user_clicks_on_the_submit_button() {

        actions.moveToElement(contactPage.submitBtn).perform();
        contactPage.submitBtn.click();

    }

    @Then("the user should see this message {string}")
    public void the_user_should_see_this_message(String expectedMessage) {

        String actualMessage = contactPage.alertMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Then("the user should see this message {string} on the first line")
    public void theUserShouldSeeThisMessageOnTheFirstLine(String expectedMessage) {

        Assert.assertTrue(contactPage.successMessage1.getText().contains(expectedMessage));
    }

    @And("the user should see this message {string} on the second line")
    public void theUserShouldSeeThisMessageOnTheSecondLine(String expectedMessage) {

        Assert.assertEquals(expectedMessage, contactPage.successMessage2.getText());
    }

    @And("the user should see {string} on the third line")
    public void theUserShouldSeeOnTheThirdLine(String expectedMessage) {

        Assert.assertEquals(expectedMessage, contactPage.successMessage3.getText());

    }

    @And("the user should see this message {string} on the last line")
    public void theUserShouldSeeThisMessageOnTheLastLine(String expectedMessage) {

        Assert.assertEquals(expectedMessage, contactPage.successMessage4.getText());

    }
}
