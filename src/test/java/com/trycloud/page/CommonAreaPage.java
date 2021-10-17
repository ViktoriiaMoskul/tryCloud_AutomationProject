package com.trycloud.page;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonAreaPage {

    // 'Dashboard' 'Files' 'Photos' 'Activity' 'Talk' 'Mail' 'Contacts' 'Circles' 'Calendar' 'Deck'
    public WebElement modules(String moduleName) {
        return Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li/a[@aria-label='" + moduleName + "']"));
    }

    @FindBy(xpath = "//div[@class='header-right']//a/span[@aria-label='Magnify icon']")
    public WebElement magnifyIcon;

    @FindBy(xpath = "//div[@class='header-right']//div[@aria-label='Notifications']")
    public WebElement notificationsIcon;

    @FindBy(xpath = "//div[@class='header-right']//div[@aria-label='Contacts menu']")
    public WebElement contactMenuIcon;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
