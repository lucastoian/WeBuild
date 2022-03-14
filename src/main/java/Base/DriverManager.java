package main.java.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;


    public static WebDriver CreateDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/java/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }


    public static void afterSuite() {
        driver.close();
        driver.quit();
    }

}