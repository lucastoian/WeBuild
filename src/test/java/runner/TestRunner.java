package test.java.runner;

import io.cucumber.testng.CucumberOptions;
import main.java.Base.CustomizeTestNGCucumberRunner;


@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/java/features/",
        glue = {"test.java.steps", "main.java.Hooks"}
)

public class TestRunner extends CustomizeTestNGCucumberRunner {

}