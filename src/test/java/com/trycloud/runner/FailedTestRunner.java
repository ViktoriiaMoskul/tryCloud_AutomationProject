package com.trycloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com/trycloud/step_definitions",
        features = "@target/rerun.txt"
//                ,tag =
)
public class FailedTestRunner {
}
