package com.trycloud.step_definitions;

import com.trycloud.page.CommonAreaPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class CommonAreaStepDefs {
    @And("verify the user see the following modules")
    public void verifyTheUserSeeTheFollowingModules(List<String> expectedModules) {

        BrowserUtil.waitFor(5);

        CommonAreaPage commonAreaPage = new CommonAreaPage();
        new Actions(Driver.getDriver()).moveToElement(commonAreaPage.hover.get(0)).pause(3000).perform();

        List<WebElement> allModules = commonAreaPage.allModules;
        List<String> actualModules = new ArrayList<>();

        for (WebElement module : allModules) {
            actualModules.add(module.getText());
        }
        System.out.println("actualModules = " + actualModules);
        System.out.println("expectedModules = " + expectedModules);
        Assert.assertEquals(expectedModules,actualModules);
    }
}
