package com.trycloud.step_definitions;

import com.trycloud.page.CommonAreaPage;
import com.trycloud.page.FilesPage;
import static com.trycloud.utilities.Driver.*;

import static com.trycloud.utilities.BrowserUtil.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilesStepDefs_US6 {
    //OBJECTS
    CommonAreaPage commonArea = new CommonAreaPage();
    FilesPage filesPage = new FilesPage();

    @When("user clicks on the Files module on top")
    public void userClicksFilesModule() {
        commonArea.waitUntilLoaderScreenDisappear();
        commonArea.modules("Files").click();
    }

    @And("user clicks the + icon")
    public void userClicksPlusIcon() {
        filesPage.plusIcon.click();
    }

    @And("user select New Folder from dropdown")
    public void selectNewFolder() {
        filesPage.plusIconOptions("New Folder");
    }

    @And("user write a new folder name")
    public void writeAFolderName() {
        filesPage.newFolderNameInputBox.sendKeys("NewFolderTest");
    }

    @Then("verify the new folder is displayed on the page")
    public void verifyNewFolderIsDisplayed() {
        Assert.assertEquals("You created NewFolderTest", filesPage.newFolderComfirmMsg.getText());
        Assert.assertEquals("New Folder Test", filesPage.sideBarNewFolderComfirmTitle.getText());
    }

    @And("user select Upload File from dropdown")
    public void selectUploadFile() {
        filesPage.plusIconOptions("Upload File").sendKeys("/Users/YuliiaNazarova/Desktop/logo.jpeg");

    }

    @And("choose file and click Open")
    public void uploadFile() {

    }

    @Then("verify the file is displayed on the page")
    public void verifyTheFileIsDisplayed() {

    }

}
