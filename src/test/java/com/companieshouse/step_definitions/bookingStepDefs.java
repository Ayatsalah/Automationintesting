package com.companieshouse.step_definitions;

import com.companieshouse.pages.BookingPage;
import com.companieshouse.pages.HomePage;
import com.companieshouse.utilities.BrowserUtils;
import com.companieshouse.utilities.ConfigurationReader;
import com.companieshouse.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class bookingStepDefs {
    BookingPage bookingPage = new BookingPage();
    HomePage homePage = new HomePage();

    Actions actions = new Actions(Driver.getDriver());

    int price = 0;
    String priceStr;
    String priceOnlyStr;

    String priceSummaryStr;

    int numberOfNights = 0;
    String numberOfNightsStr;

    @Given("the user on the Home page")
    public void the_user_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("the user clicks on check availability button")
    public void the_user_clicks_on_check_availability_button() {
        bookingPage.CheckAvailabilityBtn.click();
        BrowserUtils.sleep(3);
    }

    @When("the user selects the room and clicks on Book now button")
    public void the_user_selects_the_room_and_clicks_on_book_now_button() {

        priceStr = bookingPage.price.getText();
        priceOnlyStr = priceStr.substring(1, priceStr.indexOf(" "));

        price = Integer.parseInt(priceOnlyStr);
        bookingPage.bookNowBtn.click();

    }

    @When("the user clicks on the Reserve now button")
    public void the_user_clicks_on_the_reserve_now_button() {

        actions.moveToElement(bookingPage.reserveNowBtn).perform();

        bookingPage.reserveNowBtn.click();

    }


    @Then("the user should see a booking confirmation message {string}")
    public void the_user_should_see_a_booking_confirmation_message(String expectedMsg) {

        Assert.assertEquals(expectedMsg,bookingPage.bookingConfirmedMessage.getText());
    }

    @When("the user enters valid {string} and {string}")
    public void theUserEntersValidAnd(String checkInDate, String checkOutDate) {

        actions.click(homePage.checkIn).perform();
        BrowserUtils.sleep(3);
        bookingPage.selectDay(checkInDate).click();
        BrowserUtils.sleep(3);

        actions.click(homePage.checkOut).perform();
        BrowserUtils.sleep(3);
        bookingPage.selectDay(checkOutDate).click();
        BrowserUtils.sleep(3);

    }

    @And("the user enters the {string}, the {string}, the {string} and the {string}")
    public void theUserEntersTheTheTheAndThe(String firstName, String lastName, String email, String phone) {
        bookingPage.firstName.sendKeys(firstName);
        bookingPage.lastName.sendKeys(lastName);
        bookingPage.email.sendKeys(email);
        bookingPage.phone.sendKeys(phone);
    }


    @Then("the user should see an {string} message")
    public void theUserShouldSeeAnMessage(String expectedMeassage) {
        String actualMessage = bookingPage.alert.getText();

        Assert.assertTrue(actualMessage.contains(expectedMeassage));
    }

    @Then("the user should the the same price for the room")
    public void theUserShouldTheTheSamePriceForTheRoom() {
        priceSummaryStr = bookingPage.priceSummary.getText();

        String priceSummaryOnlyStr = priceSummaryStr.substring(1, priceSummaryStr.indexOf(" "));


        Assert.assertEquals(priceOnlyStr,priceSummaryOnlyStr);
    }

    @And("the user should see the total price")
    public void theUserShouldSeeTheTotalPrice() {
        numberOfNightsStr = priceSummaryStr.substring(priceSummaryStr.indexOf("x") + 2, priceSummaryStr.indexOf("n") - 1);

        numberOfNights = Integer.parseInt(numberOfNightsStr);
        int expectedPrice = bookingPage.calculateTotalPrice(price, numberOfNights);

        String totalPriceStr = bookingPage.totalPrice.getText();
        String actualTotalPriceStr = totalPriceStr.substring(totalPriceStr.indexOf("£") + 1);

        int actualTotalPrice = Integer.parseInt(actualTotalPriceStr);
        Assert.assertEquals(expectedPrice, actualTotalPrice);


    }

    @Given("the user clicks on the booking link")
    public void theUserClicksOnTheBookingLink() {
        homePage.selectLink("Booking").click();
    }
}
