package com.trycloud.step_definitions;

import com.trycloud.page.CommonAreaPage;
import com.trycloud.page.FilesPage;

import static com.trycloud.utilities.Driver.*;
import static com.trycloud.utilities.BrowserUtil.*;

import com.trycloud.page.LoginPage;

import static com.trycloud.utilities.ConfigReader.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FilesStepDefs_US6 {
    //OBJECTS and VARIABLES
    CommonAreaPage commonArea = new CommonAreaPage();
    FilesPage filesPage = new FilesPage();
    LoginPage login = new LoginPage();
    Actions action = new Actions(getDriver());
    String folderName = filesPage.generateRandomString(10);


    @When("user clicks on the Files module on top")
    public void userClicksFilesModule() {
        login.login(read("username"), read("password"));
        commonArea.waitUntilLoaderScreenDisappear();
        commonArea.modules("Files").click();
    }

    @And("user clicks the + icon")
    public void userClicksPlusIcon() {
        filesPage.plusIcon.click();
        waitFor(2);
    }

    @And("user select New Folder from dropdown")
    public void selectNewFolder() {
        filesPage.plusIconOptions("New folder").click();
    }

    @And("user write a new folder name")
    public void writeAFolderName() {
        filesPage.newFolderNameInputBox.sendKeys(folderName);
        filesPage.newFolderNameInputBox.sendKeys(Keys.ENTER);
    }

    @Then("verify the new folder is displayed on the page")
    public void verifyNewFolderIsDisplayed() {
        Assert.assertEquals("You created " + folderName, filesPage.newFolderComfirmMsg.getText());
        Assert.assertEquals(folderName, filesPage.sideBarNewFolderComfirmTitle.getText());
    }

    @And("user select Upload File from dropdown")
    public void selectUploadFile() {
        //filesPage.plusIconOptions("Upload file").click();
        //JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        //String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        //((JavascriptExecutor) getDriver()).executeScript(js, inputBox);
        filesPage.uploadFileHiddenInput.sendKeys("/Users/YuliiaNazarova/Desktop/logo.jpeg");

    }

    @And("choose file and click Open")
    public void uploadFile() {
        waitFor(3);
    }

    @Then("verify the file is displayed on the page")
    public void verifyTheFileIsDisplayed() {
        boolean fileUploaded = false;
        for (WebElement each : filesPage.allCheckboxes) {
            System.out.println("testingYULIIA" + each.getText());
            if (each.getText().equals("logo.jpeg")) {
                fileUploaded = true;
                break;
            }
        }
        Assert.assertTrue(fileUploaded);
    }

}
