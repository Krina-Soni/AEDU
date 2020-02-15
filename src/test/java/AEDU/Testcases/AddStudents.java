package AEDU.Testcases;

import AEDU.Pages.AddStudent;
import AEDU.Pages.StudentInformation;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class AddStudents extends Basecase {

//To test if it redirects to admission page
//    @Test
//    public void VcerifyStudentAddmissionpage() throws InterruptedException, IOException, SQLException {
//        logger = extent.createTest("To check if it redirects to admission page");
//        StudentInformation SI = new StudentInformation(driver, logger);
//        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
//        AddStudent add = new AddStudent(driver, logger);
//        add.AddStudent("", "");
//    }
//To test if the mandatory fields show validations over Student admission page.
    @Test
    public void Checkallvalidations() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("To test if the mandatory fields show validations over Student admission page");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent check = new AddStudent(driver, logger);
        check.VeryFeildValidation();
    }
//To test if the student is added
    @Test
    public void Studentadd() throws IOException, InterruptedException, SQLException {
        logger = extent.createTest("To test if the student is added ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Add = new AddStudent(driver, logger);
        Add.SetudentAddmissionform("0098", "0069", "Aanal", "Shah", "8763802109");
    }
//To check if the student csv is imported
    @Test
    public void ImortCsv() throws IOException, InterruptedException, SQLException {
        logger = extent.createTest("To check if the student csv is imported");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Import = new AddStudent(driver, logger);
        Import.Importstudentcsv();
    }
//To check admission field validation on importing csv
    @Test
    public void ImportCsvAddmission()throws IOException,InterruptedException,SQLException{
        logger=extent.createTest("To check admission field validation on importing csv ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Addmission=new AddStudent(driver,logger);
        Addmission.ImportCsvAddmissionFeildValidation();

    }
//To check firstname field validations
    @Test
    public void ImportCsvFristname()throws IOException,InterruptedException{
        logger=extent.createTest("To check firstname field validations");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Fristname=new AddStudent(driver,logger);
        Fristname.FristNameCsv();

    }
//    To check father's name field validations
    @Test
    public void ImportCsvFathersname()throws IOException,InterruptedException{
        logger=extent.createTest("To check father's name field validations ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Fathername=new AddStudent(driver,logger);
        Fathername.ImportCsvFathername();
    }
//    To check phone number field validations
    @Test
    public void ImportCsvPhonenumber()throws IOException,InterruptedException{
        logger=extent.createTest("To check phone number field validations ");
        StudentInformation SI = new StudentInformation(driver, logger);
        SI.loginWithCredentials2("addwebsolution@gmail.com", "addweb123");
        AddStudent Phonenumber=new AddStudent(driver,logger);
        Phonenumber.ImportCsvFatherphone();
    }
}