package main.java.Utility;

import main.java.Base.DriverManager;
import main.java.Elements.BrowserElement;
import main.java.Elements.TestElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;


public class Util extends DriverManager {

    public static byte[] screenshot;

    public static void takeScreenShot() {

         screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static WebElement waitElement(TestElement el){
        if (!el.getId().equals("")) {
            return new WebDriverWait(driver,3)
                    .until(driver -> driver.findElement(By.id(el.getId())));
        } else if(!el.getText().equals("")){
            return new WebDriverWait(driver,3)
                    .until(driver -> driver.findElement(By.xpath("//*[contains(text(),'"+el.getText()+"')]")));
        } else {
            return new WebDriverWait(driver,3)
                    .until(driver -> driver.findElement(By.xpath(el.getXpath())));
        }
    }



    public static void isElementDisplayed(TestElement el){

        for (int i=0;i<=5;i++) {
            try {

                WebElement element = waitElement(el);
                element.isDisplayed();
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The Element " + el.getElementName() + " is present");

    }

    public static void isElementEnabled(TestElement el){

        for (int i=0;i<=5;i++) {
            try {

                WebElement element = waitElement(el);
                element.isEnabled();
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The Element " + el.getElementName() + " is present and enabled");

    }


    public static boolean isElementDisplayedBoolean(TestElement el){

        try{

            WebElement element = waitElement(el);
            return element.isDisplayed();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean waitElementNotVisible(TestElement el){
        if (!el.getId().equals("")) {
            return new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(By.id(el.getId())));
        } else if(!el.getText().equals("")){
            return new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'"+el.getText()+"')]")));
        } else {
            return new WebDriverWait(driver, 3).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(el.getXpath())));
        }
    }

    public static boolean isElementNOTPresent(TestElement el){
        try{

            return waitElementNotVisible(el);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;

    }

    public static WebElement findEl(TestElement el){

        return waitElement(el);

    }
    public static WebElement findEl(BrowserElement el){

        return driver.findElement(el.getBy());

    }

    public static void click(TestElement el) {

        System.out.println("I click the element "+el.getElementName());
        if(!el.getId().equals("")) {
            driver.findElement(By.id(el.getId())).click();
        } else if(!el.getText().equals("")){
            driver.findElement(By.xpath("//*[contains(text(),'"+el.getText()+"')]")).click();
        } else {
            driver.findElement(By.xpath(el.getXpath())).click();
        }
    }

    public static void sendText(TestElement el, String submittedString) {
        System.out.println("I add the string "+submittedString+" to the element "+el.getElementName());
        driver.findElement(By.id(el.getId())).sendKeys(submittedString);
    }

    public static void getURL() {
        driver.get("https://www.fptindustrial.com/global/en");
    }



    /*public static void scrollToElement(String el){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = findEl(el);
        js.executeScript("arguments[0].scrollIntoViewIfNeeded();", element);

    }*/

    public static void passOverPopUpLogin(String urlStr){

        System.out.println("Pass over Pop Up");
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("sts3.reply.eu"));
        String url = driver.getCurrentUrl();
        String newUrl = url.replace("//",urlStr);
        driver.get(newUrl);
    }

    public static void selectBilocale1(TestElement el){
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div")).click();
        click(el);
    }

    public static void selectTonyResitest(TestElement el){
        driver.findElement(By.xpath("//*[@id=\"react-select-7-input\"]")).sendKeys("tony.resitest.chl@gmail.com");
        click(el);
    }

   public static void clickActionsButton(){

        driver.findElement(By.xpath("//*[contains(text(),'BL1')]/../../child::div[7]/div/button")).click();
        //System.out.println(el.getAttribute("class"));
        //System.out.println("Stop");

    }

    public static void clickActionsButtonTL2(){

        driver.findElement(By.xpath("//*[contains(text(),'TL2')]/../../child::div[7]/div/button")).click();
        //System.out.println(el.getAttribute("class"));
        //System.out.println("Stop");

    }

    /*public static void goToLastPageInPastSection(){

        WebElement buttonLast = waitElement(LeasePage.BUTTON_LAST_PAGE);
        scrollToElement(LeasePage.BUTTON_LAST_PAGE);
        if(buttonLast.isEnabled()){
           buttonLast.click();
        }

    }*/

    public static TestElement createElementCurrentDate(){
        Calendar c = Calendar.getInstance();

        int currentDay = c.get(Calendar.DAY_OF_MONTH);;
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        String monthStr;
        if(month<=9){
            monthStr = "0"+month;
        } else{
            monthStr = ""+month;
        }
        String date = currentDay+"/"+monthStr+"/"+year+", 00:00";       //20/01/2022, 00:00

        return new TestElement("",date,"","CURRENT_DATE");
    }

    public static void refreshUntilElementPresent(TestElement el){

        for(int i=0;i<=10;i++){
            if(!isElementDisplayedBoolean(el)){
                driver.navigate().refresh();
            } else{
                break;
            }

        }


    }

    public static void refreshUntilElementNOTPresent(TestElement el){

        for(int i=0;i<=10;i++){
            if(!isElementNOTPresent(el)){
                driver.navigate().refresh();
            } else{
                break;
            }

        }

    }

    public static void fillTheCalendar(){

        System.out.println("I fill the start date and the end date");

        Calendar c = Calendar.getInstance();
        int currentDay = c.get(Calendar.DAY_OF_MONTH);;
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        int nextDay = currentDay+1;
        int nextMonth = month;
        int nextYear = year;

        if(c.get(Calendar.MONTH) == Calendar.FEBRUARY ){
            if((c.get(Calendar.YEAR)%4)==0) {
                if (c.get(Calendar.DAY_OF_MONTH) == 28) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            } else {
                if (c.get(Calendar.DAY_OF_MONTH) == 27) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            }

        } else if(c.get(Calendar.MONTH)==Calendar.NOVEMBER && c.get(Calendar.MONTH)==Calendar.APRIL && c.get(Calendar.MONTH)==Calendar.JUNE && c.get(Calendar.MONTH)==Calendar.SEPTEMBER) {
            if (c.get(Calendar.DAY_OF_MONTH) == 30) {
                nextDay = 1;
                nextMonth = month + 1;
            }
        } else if (c.get(Calendar.MONTH) == Calendar.DECEMBER) {
            if (c.get(Calendar.DAY_OF_MONTH) == 31) {
                nextDay = 1;
                nextMonth = Calendar.JANUARY;
                nextYear = year + 1;
            }
        } else {
            if (c.get(Calendar.DAY_OF_MONTH) == 31) {
                nextDay = 1;
                nextMonth = month + 1;
            }
        }


        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[2]")).sendKeys("" + currentDay);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[3]")).sendKeys("" + month);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[4]")).sendKeys("" + year);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[5]")).sendKeys("0");
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[6]")).sendKeys("0");

        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[2]")).sendKeys("" + nextDay);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[3]")).sendKeys("" + nextMonth);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[4]")).sendKeys("" + nextYear);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[5]")).sendKeys("0");
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[6]")).sendKeys("0");


    }

    public static void fillTheCalendarFuture(){

        System.out.println("I fill the start date and the end date");

        Calendar c = Calendar.getInstance();
        int currentDay = c.get(Calendar.DAY_OF_MONTH)+1;;
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        int nextDay = currentDay+1;
        int nextMonth = month;
        int nextYear = year;

        if(c.get(Calendar.MONTH) == Calendar.FEBRUARY ){
            if((c.get(Calendar.YEAR)%4)==0) {
                if (c.get(Calendar.DAY_OF_MONTH) == 28) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            } else {
                if (c.get(Calendar.DAY_OF_MONTH) == 27) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            }

        } else if(c.get(Calendar.MONTH)==Calendar.NOVEMBER && c.get(Calendar.MONTH)==Calendar.APRIL && c.get(Calendar.MONTH)==Calendar.JUNE && c.get(Calendar.MONTH)==Calendar.SEPTEMBER) {
            if (c.get(Calendar.DAY_OF_MONTH) == 30) {
                nextDay = 1;
                nextMonth = month + 1;
            }
        } else if (c.get(Calendar.MONTH) == Calendar.DECEMBER) {
            if (c.get(Calendar.DAY_OF_MONTH) == 31) {
                nextDay = 1;
                nextMonth = Calendar.JANUARY;
                nextYear = year + 1;
            }
        } else {
            if (c.get(Calendar.DAY_OF_MONTH) == 31) {
                nextDay = 1;
                nextMonth = month + 1;
            }
        }


        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[2]")).sendKeys("" + currentDay);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[3]")).sendKeys("" + month);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[4]")).sendKeys("" + year);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[5]")).sendKeys("0");
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/input[6]")).sendKeys("0");

        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[2]")).sendKeys("" + nextDay);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[3]")).sendKeys("" + nextMonth);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[4]")).sendKeys("" + nextYear);
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[5]")).sendKeys("0");
        driver.findElement(By.xpath("//*[@id=\"kt_modal_select_location\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input[6]")).sendKeys("0");


    }
}

