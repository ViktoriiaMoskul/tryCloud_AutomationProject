package com.trycloud.step_definitions;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

@Before("@ui")
    public void setupDriver(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        Driver.getDriver().manage().window().maximize();
    }

    @After("@ui")
    public void tearDown(Scenario scenario){

        if(scenario.isFailed() ){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png",scenario.getName());

        }

        Driver.closeBrowser();
    }

}
