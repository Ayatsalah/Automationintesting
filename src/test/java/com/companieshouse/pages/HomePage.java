package com.companieshouse.pages;

import com.companieshouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@id='navbarNav']/ul/li")
    public List<WebElement> links;


    @FindBy(xpath = "//li[@class='nav-item']/a[.='Contact']")
    public WebElement contactLink;

    @FindBy(xpath = "//li[@class='nav-item']/a[.='Admin']")
    public WebElement adminLink;

    public WebElement selectLink(String linkName) {
        return Driver.getDriver().findElement(By.xpath("//li[@class='nav-item']/a[.='" + linkName + "']"));
    }

    public String getTheTitle(String link) {

        return Driver.getDriver().getCurrentUrl();
    }

    @FindBy(xpath = "//a[.='Book Now']")
    public WebElement bookNowBtn;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']//input[@class='form-control']")
    public WebElement checkIn;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container']//input[@class='form-control'])[2]")
    public WebElement checkOut;


}
