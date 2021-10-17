package com.trycloud.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;


public class BrowserUtil {


   //switch to the new window by Title
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }


    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Waits for element matching the locator to be visible on the page
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    //Scrolls down to an element using JavaScript
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    //Select by visible text
    public static void selectByVisibleText(WebElement elementDropdown, String visibleText) {
        Select dropdown = new Select(elementDropdown);
        dropdown.selectByVisibleText(visibleText);

    }

    /**
     * Checks element is displayed
     *
     * @param elements
     * @return
     */
    public static boolean elementIsDisplayed(List<WebElement> elements) {

        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                System.err.println(element.getText() + " is not displayed");
                return false;
            }
        }
        return true;
    }


    //check element is not located
    public static boolean waitForElementIsNotLocated(WebElement element) {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));

            return true;

        } catch (TimeoutException e) {
            System.err.println("Create Car button does not exist");
        }

        return false;
    }


    public static boolean getIsCheck(List<WebElement> allCheckboxes,WebElement nextButton){

        boolean flag=true;

        String str="";

        do{

            str= Driver.getDriver().getCurrentUrl();


            for (WebElement checkbox : allCheckboxes) {
                if(!checkbox.isSelected()) {
                    flag = false;
                    break  ;
                }
            }



            nextButton.click();
            BrowserUtil.waitFor(2);

        }while(!Driver.getDriver().getCurrentUrl().equals(str));

        return flag;
    }


}
