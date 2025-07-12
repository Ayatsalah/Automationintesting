package com.companieshouse.pages;

import com.companieshouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomPage extends BasePage {

    @FindBy(id = "createRoom")
    public WebElement createBtn;

    @FindBy(id = "roomName")
    public WebElement roomNumberInput;

    @FindBy(id = "roomPrice")
    public WebElement roomPriceInput;

    @FindBy(xpath = "//input[@value='WiFi']")
    public WebElement wifiChechBox;

    @FindBy(xpath = "//input[@value='TV']")
    public WebElement tvCheckBox;

    @FindBy(xpath = "//input[@value='Radio']")
    public WebElement radioCheckBox;

    @FindBy(xpath = "//input[@value='Refreshments']")
    public WebElement refreshmentsCheckBox;

    @FindBy(xpath = "//input[@value='Safe']")
    public WebElement safeCheckBox;

    @FindBy(xpath = "//input[@value='Views']")
    public WebElement viewsCheckBox;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement alertMessage;

    @FindBy(xpath = "//div[@class='col-sm-5']")
    public WebElement roomDetails;

    @FindBy(xpath = "//button[.='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateBtn;

    @FindBy(xpath = "//input[@id='roomName']")
    public WebElement updatingRoomNumber;

    @FindBy(xpath = "//input[@id='roomPrice']")
    public WebElement updatingPrice;

    @FindBy(xpath = "//input[@id='wifiCheckbox']")
    public WebElement updatingWifi;

    @FindBy(xpath = "//input[@id='tvCheckbox']")
    public WebElement updatingTv;

    @FindBy(xpath = "//input[@id='radioCheckbox']")
    public WebElement updatingRadio;

    @FindBy(xpath = "//input[@id='refreshmentsCheckbox']")
    public WebElement updatingRefreshments;

    @FindBy(xpath = "//input[@id='viewsCheckbox']")
    public WebElement updatingViews;

    @FindBy(xpath = "//input[@id='safeCheckbox']")
    public WebElement updatingSafe;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement description;

    @FindBy(xpath = "//div[@class='col-sm-10']")
    public WebElement updatedRoomNumber;

    @FindBy(xpath = "//div[@class='col-sm-6']/p")
    public WebElement updatedRoomType;

    @FindBy(xpath = "(//div[@class='col-sm-6']/p)[2]")
    public WebElement updatedDescription;

    @FindBy(xpath = "(//div[@class='col-sm-6']/p)[3]")
    public WebElement updatedAccessible;
    @FindBy(xpath = "(//div[@class='col-sm-6']/p)[4]")
    public WebElement updatedFeatures;
    @FindBy(xpath = "(//div[@class='col-sm-6']/p)[5]")
    public WebElement updatedRoomPrice;



    public WebElement room(String roomNumber) {

        return Driver.getDriver().findElement(By.xpath("//div[@class='col-sm-1']/p[.='" + roomNumber + "']"));
    }

    public WebElement deleteBtn(String roomNumber) {

        return Driver.getDriver().findElement(By.xpath("//p[text()='" + roomNumber + "']/ancestor::div[@data-testid='roomlisting']//span[@class='fa fa-remove roomDelete']"));
    }

    public WebElement returnUpdateRoomNumber(String number){
        return Driver.getDriver().findElement(By.xpath("//p[.='"+number+"']"));
    }



}
