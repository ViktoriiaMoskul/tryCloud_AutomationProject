package com.trycloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", // or "src/test/resources/features",
        glue = "com/trycloud/step_definitions",
        publish = true,
        plugin = {"pretty", "html:target/cucumber.html" ,
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target"
        },
        dryRun = true,
        tags = "@ui")

public class TestRunner {

}
