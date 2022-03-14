package test.java.pages;

import main.java.Elements.BrowserElement;
import main.java.Elements.TestElement;
import org.openqa.selenium.By;

public class NEWPage {
    public static final BrowserElement TEST1 = new BrowserElement(
            new By[]{By.id("")});
    public static final BrowserElement TEST2 = new BrowserElement(
            new By[]{By.xpath("")});
    public static final BrowserElement TEST3 = new BrowserElement(
            new By[]{By.className("")});
    public static final BrowserElement ENGINE_BUTTON = new BrowserElement(
            new By[]{By.xpath("//*[contains(text(),'ENGINES')]")});
}
