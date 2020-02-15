//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package AEDU.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActionClass {
    public static WebDriver driver;
    public static ExtentTest test;

    public ActionClass(WebDriver driver, ExtentTest test)
    {
        this.driver=driver;
        this.test=test;
    }

    public void clickOnObject(WebElement element)
    {
        try {
            if(element.isDisplayed())
            {
                element.click();
                test.log(Status.INFO,"Sucessfully clicked on object");
                System.out.println("Sucessfully clicked on object");
                //element.getAttribute("name")
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void setValueinTextbox( WebElement element, String value)
    {
        try {
            if(element.isDisplayed())
            {
                element.clear();
                element.sendKeys(value);
                System.out.println("Succesfully entered '"+value+"' in object");
                test.log(Status.PASS,"Succesfully entered '"+value+"' in object :");
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");

            }
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void CompareList(ArrayList<Integer> listNames, ArrayList<Integer> listNames1)
    {
        try {
            if(listNames.equals(listNames1)==true)
            {
                test.log(Status.INFO,"Result Matched with DB");
                System.out.println("Result Matched with DB");

            }
            else
            {
                System.out.println("Result Doesn't match with DB");
                test.log(Status.FAIL,"Result Doesn't match with DB");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void setValueinPortalField(WebElement element) {

        try{
            if(element.isDisplayed()){
                element.click();
                element.sendKeys("Elance");
                element.sendKeys(Keys.ENTER);

                element.click();
                element.sendKeys("Freelancer");
                element.sendKeys(Keys.ENTER);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void captureScreen(String testcaseName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png" ;
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenshotPath);
        FileUtils.copyFile(SrcFile, DestFile);
        test.addScreenCaptureFromPath(screenshotPath);

    }

}
