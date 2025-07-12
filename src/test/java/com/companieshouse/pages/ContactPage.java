package com.companieshouse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@id='subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement messageInput;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='card-body p-4']/h3[@class='h4 mb-4']")
    public WebElement successMessage1;

    @FindBy(xpath = "//div[@class='card-body p-4']/p")
    public WebElement successMessage2;

    @FindBy(xpath = "(//div[@class='card-body p-4']/p)[2]")
    public WebElement successMessage3;

    @FindBy(xpath = "(//div[@class='card-body p-4']/p)[3]")
    public WebElement successMessage4;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement alertMessage;

}
