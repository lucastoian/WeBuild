package main.java.Hooks;



import io.cucumber.java.*;
import main.java.Base.DriverManager;
import main.java.Utility.Util;

import java.io.IOException;

public class Hook extends DriverManager {

    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        scenario.attach(Util.screenshot, "image/jpg", scenario.getName());
    }

    @Before
    public void beforeScenario() {

        Util.CreateDriver();
    }

    @After
    public void closeDriver() {

        afterSuite();
    }
}
