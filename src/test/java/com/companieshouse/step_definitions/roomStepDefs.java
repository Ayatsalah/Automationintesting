package com.companieshouse.step_definitions;

import com.companieshouse.pages.RoomPage;
import com.companieshouse.utilities.BrowserUtils;
import com.companieshouse.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class roomStepDefs {
    RoomPage roomPage = new RoomPage();

    Select selectType = new Select(Driver.getDriver().findElement(By.id("type")));
    Select selectAccessibility = new Select(Driver.getDriver().findElement(By.id("accessible")));

    String roomNumber, roomType, roomAccessible, roomPrice;

    String roomDetailes = "";


    @When("the user enters the room {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_user_enters_the_room_and(String number, String type, String accessible, String price, String wifi, String tv, String radio, String refreshments, String safe, String views) {
        roomNumber = number;
        roomType = type;
        roomAccessible = accessible;
        roomPrice = price;

        roomPage.roomNumberInput.sendKeys(number);
        BrowserUtils.sleep(1);

        selectType.selectByVisibleText(type);
        BrowserUtils.sleep(1);
        selectAccessibility.selectByVisibleText(accessible);
        BrowserUtils.sleep(1);

        roomPage.roomPriceInput.sendKeys(price);
        BrowserUtils.sleep(1);

        if (wifi.equals("Yes")) {
            roomPage.wifiChechBox.click();
            roomDetailes += ("WiFi, ");
        }
        BrowserUtils.sleep(1);
        if (tv.equals("Yes")) {
            roomPage.tvCheckBox.click();
            roomDetailes += ("TV, ");
        }
        BrowserUtils.sleep(1);
        if (radio.equals("Yes")) {
            roomPage.radioCheckBox.click();
            roomDetailes += ("Radio, ");
        }
        BrowserUtils.sleep(1);
        if (refreshments.equals("Yes")) {
            roomPage.refreshmentsCheckBox.click();
            roomDetailes += ("Refreshments, ");
        }
        BrowserUtils.sleep(1);
        if (safe.equals("Yes")) {
            roomPage.safeCheckBox.click();
            roomDetailes += ("Safe, ");
        }
        BrowserUtils.sleep(1);
        if (views.equals("Yes")) {
            roomPage.viewsCheckBox.click();
            roomDetailes += ("Views");
        }

        BrowserUtils.sleep(1);


    }

    @When("the clicks Create button")
    public void the_clicks_create_button() {
        roomPage.createBtn.click();
        BrowserUtils.sleep(1);
    }

    @Then("the user should see room details")
    public void the_user_should_see_room_details() {
        Assert.assertEquals(roomNumber, roomPage.room(roomNumber).getText());

    }

    @Then("the user should see room details {string}, {string}, {string}, {string}")
    public void theUserShouldSeeRoomDetails(String number) {

    }

    @Then("the user should see room {string}")
    public void theUserShouldSeeRoom(String number) {
        Assert.assertEquals(number, roomPage.room(number).getText());
    }

    @Then("the user should see this {string}")
    public void theUserShouldSeeThis(String expectedMessage) {

        Assert.assertEquals(expectedMessage, roomPage.alertMessage.getText());
    }

    @Then("the user should see the new room {string} appears in the room list")
    public void theUserShouldSeeTheNewRoomAppearsInTheRoomList(String roomNumber) {
        Assert.assertEquals(roomNumber, roomPage.room(roomNumber).getText());
    }

//    @And("the user should see the room details {string}")
//    public void theUserShouldSeeTheRoomDetails(String expectedRoomDetails) {
//
//            Assert.assertEquals(expectedRoomDetails, roomPage.roomDetails.getText());
//
//    }
}
