package com.companieshouse.step_definitions;

import com.companieshouse.pages.HomePage;
import com.companieshouse.pages.LoginPage;
import com.companieshouse.utilities.BrowserUtils;
import com.companieshouse.utilities.ConfigurationReader;
import com.companieshouse.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class loginStepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @When("the user clicks on Admin Link")
    public void theUserClicksOnAdminLink() {
        homePage.adminLink.click();
    }

    @When("the user enters valid {string} and valid {string} and clicks on Login Button")
    public void the_user_enters_valid_and_valid_and_clicks_on_login_button(String username, String password) {
        loginPage.login(ConfigurationReader.getProperty(username), ConfigurationReader.getProperty(password));

    }

    @Then("the user login successfully")
    public void the_user_login_successfully() {
        Assert.assertTrue(loginPage.logoutBtn.isDisplayed());
    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String expectedMessage) {
        String actualMessage = loginPage.alertMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @When("the user enters the {string} and the {string} and clicks on Login Button")
    public void theUserEntersTheAndTheAndClicksOnLoginButton(String username, String Password) {
        loginPage.login(username, Password);
    }
}
