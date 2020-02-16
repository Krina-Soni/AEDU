package AEDU.Testcases;
import AEDU.constants.CommonVar;
import org.junit.Before;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import AEDU.Reports.ReportClass;

import java.sql.SQLException;

public class Basecase extends ReportClass {

    public static WebDriver driver;

    /*
 Below method will execute before each testcase.
     */
    @BeforeMethod
    public void initialize() throws SQLException {
        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "chromedriver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-debugging-port=9222");
//        options.addArguments("--headless");
//        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);
//        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        driver = new ChromeDriver();
        CommonVar common=new CommonVar();
        driver.get(common.url);
        driver.manage().window().maximize();
    }


    /*
 Below method will execute after each testcase.
     */
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
