package test.java.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import main.java.Base.Functions_Settings;
import main.java.Elements.BrowserElement;
import main.java.Utility.Util;
import org.junit.Assert;
import static main.java.Utility.Util.findEl;

public class WebStep {


    @And("I check that {}.{} is displayed")
    public void isElementVisible(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).isDisplayed();
        Util.takeScreenShot();
    }


    @And("I check that {}.{} is displayed and enabled")
    public void isElementVisibleAndEnabled(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).isDisplayed();
        findEl(el).isEnabled();
        Util.takeScreenShot();
    }

    @And("I check that {}.{} is enabled")
    public void isElementEnabled(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).isEnabled();
        Util.takeScreenShot();
    }


    @And("I check that {}.{} is not displayed")
    public void isElementPresent(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        boolean elem;
        try {
            findEl(el).isDisplayed();
            elem = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            elem = false;
        }
        Assert.assertFalse(elem);
    }

    @And("I input in {}.{} the text {string}")
    public void insertText(String className, String fieldName, String text) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).isDisplayed();
        findEl(el).sendKeys(text);
        Util.takeScreenShot();
    }

    @And("I check that the element {}.{} contains the text {string}")
    public void checkText(String className, String fieldName, String text) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        String elText = findEl(el).getText();
        Assert.assertTrue(elText.contains(text));
        Util.takeScreenShot();

    }

    @And("I clear the field {}.{}")
    public void insertText(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).isDisplayed();
        findEl(el).clear();
        Util.takeScreenShot();
    }

    @And("I click {}.{}")
    public static void ClickEl(String className, String fieldName) throws Exception {
        BrowserElement el = Functions_Settings.getPageElementByString(className, fieldName);
        findEl(el).click();
        Util.takeScreenShot();
    }

    @And("I wait {int} seconds")
    public static void waitSec(int sec) {
        int millis = sec * 1000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("I navigate to FPT page")
    public void navigateToFpt()  {
        Util.getURL();
        Util.takeScreenShot();
    }
}
