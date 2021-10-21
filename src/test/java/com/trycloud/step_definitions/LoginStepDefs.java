package com.trycloud.step_definitions;

import com.trycloud.page.CommonAreaPage;
import com.trycloud.page.LoginPage;
import static com.trycloud.utilities.ConfigReader.*;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.awt.dnd.DragGestureEvent;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonArea = new CommonAreaPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

    }

    @When("user enter valid {string} and {string} and user click login button")
    public void userEnterValidAnd(String username, String password) {

        loginPage.login(username,password);
        //commonArea.waitUntilLoaderScreenDisappear();
    }


    @Then("Verify user launched to the dashboard")
    public void verifyUserLaunchedToTheDashboard() {
        String expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @When("user enters invalid credentials and user click login button")
    public void userEnterInvalidCredentials() {
        loginPage.login(read("invalidUser"), read("invalidPass"));
    }

    @Then("“Wrong username or password.” message should be displayed")
    public void wrongUsernameOrPasswordMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }

}
