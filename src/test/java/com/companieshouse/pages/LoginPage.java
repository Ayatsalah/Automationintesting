package com.companieshouse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='doLogin']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//a[@href='/admin/message']")
    public WebElement messagesLink;



    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();


    }
}
