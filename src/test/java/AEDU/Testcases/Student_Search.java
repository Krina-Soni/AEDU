package AEDU.Testcases;
import AEDU.Pages.StudentInformation;
import AEDU.Pages.StudentSearch;
import AEDU.Pages.Studentcategory;
import AEDU.Utilities.DatabaseFunctions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Student_Search extends Basecase {



//  Test if all the active students are listed. DONE
    @Test
    public void searchStudent() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Verify that Default Keyword Search details are matched with Database or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.ListStudentDetail();
        Thread.sleep(5000);
        driver.quit();
    }

//    Test if all the active students of selected class are displayed. DONE
    @Test
    public void SelectClassActive() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If Students are Active And We filtered By Class only, Is records match with DB or not?");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckDataByClassActive();
        Thread.sleep(5000);
        driver.quit();
    }

//    Test if all the active students of selected class and section are displayed. DONE
    @Test
    public void SelectClassSectionActive() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If Students are Active And We filtered By Class with section & that records match with DB or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckDataByClassAndSectionActive();
        Thread.sleep(5000);
        driver.quit();
    }

//    Test if all the inactive students of selected class and section are displayed. NOT DONE
//    @Test
//    public void SelectClassSectionInactive() throws InterruptedException, IOException, SQLException{
//        logger = extent.createTest("Check If InActive Students are filtered By Class with section & that records match with DB or not");
//        StudentInformation SI = new StudentInformation(driver,logger);
//        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
//        StudentSearch searchStudent= new StudentSearch(driver,logger);
//        searchStudent.CheckDataByClassAndSectionInctive();
//        Thread.sleep(5000);
//        driver.quit();
//    }

//    Test if all the active students of selected class are displayed. DONE
    @Test
    public void SelectClassInactive() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If InActive Students are filtered By Class & that records match with DB or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckDataByClassInactive();
        Thread.sleep(5000);
        driver.quit();
    }

//    Test if the searched keyword data are listed. DONE
    @Test
    public void SearchKeywordInAllReference() throws InterruptedException, IOException, SQLException{
        logger = extent.createTest("Check If InActive Students are filtered By Class & that records match with DB or not");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        StudentSearch searchStudent= new StudentSearch(driver,logger);
        searchStudent.CheckForKeyWordSearch();
        Thread.sleep(5000);
        driver.quit();
    }
}