package com.companieshouse.pages;

import com.companieshouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomPage extends BasePage{

    @FindBy(id = "createRoom")
    public WebElement createBtn;

    @FindBy(id = "roomName")
    public WebElement roomNumberInput;

    @FindBy(id = "roomPrice")
    public WebElement roomPriceInput;

    @FindBy(xpath="//input[@value='WiFi']")
    public WebElement wifiChechBox;

    @FindBy(xpath="//input[@value='TV']")
    public WebElement tvCheckBox;

    @FindBy(xpath="//input[@value='Radio']")
    public WebElement radioCheckBox;

    @FindBy(xpath="//input[@value='Refreshments']")
    public WebElement refreshmentsCheckBox;

    @FindBy(xpath="//input[@value='Safe']")
    public WebElement safeCheckBox;

    @FindBy(xpath="//input[@value='Views']")
    public WebElement viewsCheckBox;

    @FindBy(xpath="//div[@class='alert alert-danger']")
    public WebElement alertMessage;

    @FindBy(xpath = "//div[@class='col-sm-5']")
    public WebElement roomDetails;

public WebElement room(String roomNumber){

return Driver.getDriver().findElement(By.xpath("//div[@class='col-sm-1']/p[.='"+roomNumber+"']"));
}


}
