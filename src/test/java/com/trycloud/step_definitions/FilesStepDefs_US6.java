package com.trycloud.step_definitions;

import com.trycloud.page.CommonAreaPage;
import com.trycloud.page.FilesPage;
import static com.trycloud.utilities.BrowserUtil.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class FilesStepDefs_US6 {
    //OBJECTS and VARIABLES
    CommonAreaPage commonArea = new CommonAreaPage();
    FilesPage filesPage = new FilesPage();
    String folderName = filesPage.generateRandomString(10);


    @When("user clicks on the Files module on top")
    public void userClicksFilesModule() {
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
            System.out.println(each.getText());
            if (each.getText().trim().equals("logo")) {
                fileUploaded = true;
                System.out.println("each = " + each);
                break;
            }
        }
        Assert.assertTrue(fileUploaded);
    }

}


