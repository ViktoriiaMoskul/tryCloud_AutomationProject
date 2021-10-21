package com.trycloud.page;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="user")
    private WebElement usernameBox;

    @FindBy(id="password")
    private WebElement passwordBox;

    @FindBy(id="submit-form")
    private WebElement loginBtn;

    @FindBy(xpath = "//fieldset/p[3]")
    public WebElement errorMsg;

    public void login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }







}
