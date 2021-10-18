package com.trycloud.page;

import static com.trycloud.utilities.Driver.*;

import com.trycloud.utilities.Driver;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    @FindBy(css = "a.button.new")
    public WebElement plusIcon;

    @FindBy(css = "label[for='select_all_files']")
    public WebElement selectAllFilesCheckbox;

    @FindBy(xpath = "//span[@class='nametext']")
    public List<WebElement> allCheckboxes;

    @FindBy(css = "input#view13-input-folder")
    public WebElement newFolderNameInputBox;

    @FindBy(xpath = "//div[@class='app-sidebar-header__title-container']")
    public WebElement sideBarNewFolderComfirmTitle;

    @FindBy(css = "div.activitysubject")
    public WebElement newFolderComfirmMsg;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileHiddenInput;

    //'All files' 'Recent' 'Favorites' 'Shares' 'Tags' etc
    public WebElement sideModules(String nameOfModule) {
        return getDriver().findElement(By.xpath("//a[text()='" + nameOfModule + "']"));
    }

    //'New folder' 'New document' etc
    public WebElement plusIconOptions(String nameOfOption) {
        return getDriver().findElement(By.xpath("//span[@class='displayname'][ text()='" + nameOfOption + "']"));
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);

    }
    //constructor
    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
