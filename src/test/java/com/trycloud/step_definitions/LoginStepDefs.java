package com.trycloud.step_definitions;

import com.trycloud.page.LoginPage;
import com.trycloud.utilities.ConfigReader;
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

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

    }

    @When("user enter valid {string} and {string} and user click login button")
    public void userEnterValidAnd(String username, String password) {
        loginPage.login(username, password);
    }


    @Then("Verify user launched to the dashboard")
    public void verifyUserLaunchedToTheDashboard() {
        String expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    @When("user enters invalid credentials and user click login button")
    public void userEnterInvalidCredentials() {
        loginPage.login(ConfigReader.read("invalidUser"), ConfigReader.read("invalidPass"));
    }

    @Then("“Wrong username or password.” message should be displayed")
    public void wrongUsernameOrPasswordMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }

}
