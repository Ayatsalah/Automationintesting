package com.companieshouse.pages;

import com.companieshouse.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
