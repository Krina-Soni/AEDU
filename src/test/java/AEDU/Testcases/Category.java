package AEDU.Testcases;


import AEDU.Pages.StudentInformation;
import AEDU.Pages.Studentcategory;
import org.testng.annotations.Test;

import java.io.IOException;

public class Category extends Basecase {
    @Test
    public void addcategory() throws InterruptedException, IOException {
        logger = extent.createTest("Check the add category functionality");
        Studentcategory add = new Studentcategory(driver,logger);
        add.addstudnetcategory("test","addwebsolution@gmail.com","addweb123","","Testedit");
        driver.quit();


    }
    @Test
    public void Blankdatavalidation()throws IOException,InterruptedException{
        logger = extent.createTest("Check with the blank validation");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        Studentcategory blank=new Studentcategory(driver,logger);
        blank.Blankvalidations();
        driver.quit();


    }
    @Test
    public void ValidationforspaceVAlues() throws InterruptedException, InterruptedException, IOException {
        logger = extent.createTest("Check with the value as space validation");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        Studentcategory Space=new Studentcategory(driver,logger);
        Space.validationforspacevalue(" ");
        driver.quit();

    }
    @Test
    public void Editcategorys() throws InterruptedException, InterruptedException, IOException {
        logger = extent.createTest("Check with the Edit category");
        StudentInformation SI = new StudentInformation(driver,logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com","addweb123");
        Studentcategory edit=new Studentcategory(driver,logger);
        edit.editcategory("Test");
        driver.quit();

    }

}