package com.trycloud.page;

import static com.trycloud.utilities.Driver.*;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilesPage {
    WebElement actionsBtn;

    @FindBy(xpath = "//*[@id=\"fileList\"]//a/span[.='TextHere']/../span[@class='fileactions']/a[2]")
    public WebElement actionHover;

    @FindBy(xpath = "//li[@data-id='favorites']")
    public WebElement favoritesModule;


    @FindBy(xpath = "//a[@class='name']//span[.='Readme']")
    public WebElement readMeFile;

    @FindBy(css = "a.button.new")
    public WebElement plusIcon;

    @FindBy(css = "label[for='select_all_files']")
    public WebElement selectAllFilesCheckbox;

    @FindBy(xpath = "//span[@class='nametext']")
    public List<WebElement> allCheckboxes;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> allCheckbox;

    @FindBy(css = "input#view13-input-folder")
    public WebElement newFolderNameInputBox;

    @FindBy(xpath = "//div[@class='app-sidebar-header__title-container']")
    public WebElement sideBarNewFolderComfirmTitle;

    @FindBy(css = "div.activitysubject")
    public WebElement newFolderComfirmMsg;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement uploadFileHiddenInput;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> favouriteList;

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

    public void chooseFile(String fileName){
        String beforeFileName="//*[@id=\"fileList\"]//a/span[.=";
        String afterFileName="']/../span[@class='fileactions']/a[2]/span[1]";


        BrowserUtil.waitFor(3);

        actionsBtn=Driver.getDriver().findElement(By.xpath(beforeFileName+"'"+fileName+afterFileName));
        actionsBtn.click();


        System.out.println("Test");
        //new Select(actionsBtn).selectByVisibleText("Add to favorites");

    }
    public void chooseAction(String action) {
        BrowserUtil.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//li//span[contains(normalize-space(.),'"+action+"')]")).click();
    }

    public boolean verifyFileChosen(String fileName){
      for (WebElement each:allCheckbox)
          if (each.getText().equalsIgnoreCase(fileName)){
              return true;
          }
        return false;
    }


}
