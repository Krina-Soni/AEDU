package AEDU.Reports;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportClass {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void initReport() throws SQLException
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AEDU_ScriptExecution_Report.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "AEDU");
        extent.setSystemInfo("Environment", "AEDU Automation Reports");
        extent.setSystemInfo("User Name", "Krina");

        htmlReporter.config().setDocumentTitle("AEDU Testcase");
        htmlReporter.config().setReportName("AEDU Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();

    }
}
