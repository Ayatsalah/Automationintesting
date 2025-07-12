package com.companieshouse.pages;

import com.companieshouse.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage {


    @FindBy(xpath = "//input[@class='form-control react-datepicker-ignore-onclickoutside']")
    public WebElement checkIn;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']//input[@class='form-control']")
    public WebElement checkOut;

    @FindBy(xpath = "//button[.='Check Availability']")
    public WebElement CheckAvailabilityBtn;

    @FindBy(xpath = "//a[.='Book now']")
    public WebElement bookNowBtn;

    @FindBy(xpath = "//button[.='Reserve Now']")
    public WebElement reserveNowBtn;


    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;


    public WebElement selectDay(String day) {
        WebElement Day = Driver.getDriver().findElement(By.xpath("//div[.=" + day + "]"));
        return Day;

    }

    @FindBy(xpath = "//h2[.='Booking Confirmed']")
    public WebElement bookingConfirmedMessage;

    @FindBy(xpath = "//div[@class='fw-bold fs-5']")
    public WebElement price;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between mb-2']")
    public WebElement priceSummary;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between fw-bold']")
    public WebElement totalPrice;



// this method used to calculate the total price
    public int calculateTotalPrice(int pricePerNight, int numberOfNights) {
        int cleaningFees = 25;
        int serviceFees = 15;


        return (pricePerNight * numberOfNights) + cleaningFees + serviceFees;
    }



}
