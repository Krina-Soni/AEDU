package AEDU.Pages;

import AEDU.Utilities.DatabaseFunctions;
import AEDU.constants.CommonVar;
import AEDU.Actions.VerificationClass;
import AEDU.Actions.ActionClass;
import AEDU.Pages.StudentInformation;
import com.aventstack.extentreports.ExtentTest;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PromoteStudents {
    WebDriver driver1;
    ExtentTest extentTest;
    Connection conn = null;
    //Docker
    String url = "jdbc:mysql://localhost:6603/";
    //localDB
//    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "aedu-dev1";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
    Statement statement;
    ResultSet queryRs;
    ResultSet Qcount;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"form-username\"]\n")
    private WebElement username;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"form-password\"]\n"
    )
    private WebElement password1;

    @FindBy(how = How.XPATH,
            using = "/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button"
    )
    private WebElement submitbtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement sidemenustudentinfomenuclick;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement PromoteStudentMenu;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"sibe-box\"]/ul[2]/li[1]/ul/li[1]/a"
    )
    private WebElement ClickOnStudentDetails;

    @FindBy(
            how = How.NAME,
            using = "class_id"
    )
    private WebElement classfeild;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]"
    )
    private WebElement sectionfeild;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[2]/button"
    )
    private WebElement searchbtn;
    @FindBy(
            how = How.XPATH,
            using = " /html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div/div[1]/div/span/p"
    )
    private WebElement classfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div/div[2]/div/span/p"
    )
    private WebElement sectionfeildvalidation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/a/span"
    )
    private WebElement ClickOnStudentInformation;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[4]/a"
    )
    private WebElement ClickOnPromoteStudent;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]/option[7]"
    )
    private WebElement selectoption;

    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]/option[3]"
    )
    private WebElement selectoptionforsection;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"session_id\"]"
    )
    private WebElement Promoteinsessionclcik;
    //*[@id="session_id"]/option[3]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"session_id\"]/option[3]"
    )
    private WebElement SelectSession;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_promote_id\"]"
    )
    private WebElement PromoteClass;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_promote_id\"]"
    )
    private WebElement PromoteSession;
    //*[@id="class_promote_id"]/option[7]
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_promote_id\"]/option[7]"
    )
    private WebElement SelectclassforPromote;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_promote_id\"]/option[3]"
    )
    private WebElement SelectsectionforPromote;

    @FindBy(
            how = How.XPATH,
            using = " /html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[3]/a"
    )
    private WebElement Promotebtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[2]/td"
    )
    private WebElement Nodatabehavormatch;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[2]/div/div/div[3]/button[1]"
    )
    private WebElement Savebtnpopup;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[2]/td[6]/div[2]/label/input"
    )
    private WebElement Leavbtn;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/aside/div/section/ul[2]/li[1]/ul/li[6]/a"
    )
    private WebElement LeavingStudentSidemenu;
    @FindBy(
            how = How.XPATH,
            using = "  //*[@id=\"class_id\"]"
    )
    private WebElement LeavingStudentclass;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"section_id\"]"
    )
    private WebElement LeavingStudentSection;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"class_id\"]/option[3]"
    )
    private WebElement LeavingStudentSelectclass;
    @FindBy(
            how = How.XPATH,
            using = " //*[@id=\"section_id\"]/option[2]"
    )
    private WebElement LeavingStudentSelectSection;
    @FindBy(
            how = How.XPATH,
            using = "  /html/body/div[1]/div[1]/section[2]/div/div[1]/div/div[2]/div/div[1]/div/form/div[3]/div/button"
    )
    private WebElement LeavingSearch;
    @FindBy(
            how = How.XPATH,
            using = "/html/body/div[1]/div[1]/section[2]/div/div[2]/div/div[2]/div/div[2]/label/input"
    )
    private WebElement SearchFeild;

    public PromoteStudents(WebDriver driver, ExtentTest test) {

        this.driver1 = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);

    }

    public void Promote(String username1, String pwd) throws IOException {

        ActionClass actionClass = new ActionClass(driver1, extentTest);
        actionClass.clickOnObject(username);
        actionClass.setValueinTextbox(this.username, username1);
        actionClass.clickOnObject(password1);
        actionClass.setValueinTextbox(this.password1, pwd);
        actionClass.clickOnObject(this.submitbtn);
        actionClass.clickOnObject(this.sidemenustudentinfomenuclick);
//        driver.get("https://dev1.aedu.co.in/admin/stdtransfer/index");

    }

    public void validation(String add1) throws IOException, InterruptedException {
        driver1.get("https://dev1.aedu.co.in/admin/stdtransfer/index");
        ActionClass actionClass5 = new ActionClass(driver1, extentTest);
        actionClass5.clickOnObject(searchbtn);
        ActionClass actionClass = new ActionClass(this.driver1, extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.ClickOnPromoteStudent);
        actionClass.clickOnObject(this.searchbtn);
        VerificationClass very = new VerificationClass(driver1, extentTest);
        very.verifyTextPresent(this.classfeildvalidation, "The Class field is required.");
        very.verifyTextPresent(this.sectionfeildvalidation, "The Section field is required.");
        //section feild validation
    }

    public void feildvalidations() throws IOException, IOException {
        ActionClass actionClass1 = new ActionClass(this.driver1, extentTest);
        actionClass1.clickOnObject(this.classfeild);
        actionClass1.clickOnObject(this.selectoption);
        actionClass1.clickOnObject(this.searchbtn);
        VerificationClass very1 = new VerificationClass(driver1, extentTest);
        very1.verifyTextPresent(this.sectionfeildvalidation, "The Section field is required.");

    }

    public void classfeildvalidations() throws IOException, IOException {
        if (selectoption.isSelected() == true) {
            System.out.println("hii");
            ActionClass actionClass2 = new ActionClass(this.driver1, extentTest);
            actionClass2.clickOnObject(this.sectionfeild);
            actionClass2.clickOnObject(this.selectoptionforsection);

        } else {
            VerificationClass very3 = new VerificationClass(driver1, extentTest);
            very3.verifyTextPresent(this.classfeildvalidation, "The Class field is required");
        }
        //check the class wise filter data with db
    }


    public Object[] listdata() throws IOException, InterruptedException, SQLException {

        ActionClass actionClass4 = new ActionClass(this.driver1, extentTest);
        actionClass4.clickOnObject(this.sidemenustudentinfomenuclick);
        Thread.sleep(3000);
        actionClass4.clickOnObject(this.ClickOnPromoteStudent);
        actionClass4.clickOnObject(this.classfeild);
        actionClass4.clickOnObject(this.selectoption);
        if (selectoption.isSelected() == true) {

            actionClass4.clickOnObject(this.sectionfeild);
            actionClass4.clickOnObject(this.selectoptionforsection);
            actionClass4.clickOnObject(this.searchbtn);
            JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver1;
            jsetaskscore.executeScript("scrollBy(0, 300)");
            List<WebElement> ListStudent = driver1.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr"));

            int listsize = ListStudent.size();
            System.out.println(listsize);
            ArrayList listNames1 = new ArrayList();
            for (int i = 2; i <= listsize; i++) {
                String s = driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[" + i + "]/td[1]")).getText();
                System.out.println("Value in list is: " + s);
                listNames1.add(driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[\" + i + \"]/td[1]")).getText());
            }
            DatabaseFunctions DAB = new DatabaseFunctions(extentTest);
            conn = DAB.connect();
            statement = conn.createStatement();
            String students = "SELECT student_session.id, student_session.session_id, students.firstname, students.lastname, students.is_active, students.is_inactive, classes.class, students.admission_no FROM `student_session` INNER JOIN students ON student_session.student_id = students.id INNER JOIN classes ON student_session.class_id=classes.id \n" +
                    "WHERE student_session.session_id='15' AND classes.class='9th' AND student_session.is_inactive='no' AND students.id  NOT IN (SELECT student_id FROM promot_student)";
            queryRs = statement.executeQuery(students);
            ArrayList listNames = new ArrayList();

            while (queryRs.next()) {
                String s1 = null;
                s1 = queryRs.getString("students.admission_no");
                System.out.println("Admission no. is " + s1);
                listNames.add(queryRs.getString("students.admission_no"));

            }
            System.out.println(listNames.equals(listNames1));

            actionClass4.CompareList(listNames, listNames1);

            actionClass4.captureScreen("Default Keyword search");
            return listNames1.toArray();
        } else {
            VerificationClass very = new VerificationClass(driver1, extentTest);
            very.verifyTextPresent(this.classfeildvalidation, "The Class field is required");
        }
//        return listNames1.toArray();

        return new Object[0];
    }


//    Promote the student into a different class
    public void Promoteinsession() throws InterruptedException, IOException, SQLException {
        ActionClass actionClass=new ActionClass(this.driver1,extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.ClickOnPromoteStudent);
        actionClass.clickOnObject(this.classfeild);
        actionClass.clickOnObject(this.selectoption);
        actionClass.clickOnObject(this.sectionfeild);
        actionClass.clickOnObject(this.selectoptionforsection);
        actionClass.clickOnObject(this.searchbtn);
        actionClass.clickOnObject(this.Promoteinsessionclcik);
        actionClass.clickOnObject(this.SelectSession);
        actionClass.clickOnObject(this.PromoteClass);
        actionClass.clickOnObject(this.SelectclassforPromote);
        actionClass.clickOnObject(this.PromoteSession);
        actionClass.clickOnObject(this.SelectsectionforPromote);


        Thread.sleep(3000);
        List<WebElement> ListPromoteStudent = driver1.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr"));
        int listsize = ListPromoteStudent.size();
        ArrayList <String>  PromoteStudentList = new ArrayList<String>();
        for(int i=2; i<=listsize; i++){
            String s = driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[" + i +"]/td[1]")).getText();
            System.out.println("Values in the list: "+ s);
            PromoteStudentList.add(driver1.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[2]/form/div[2]/table/tbody/tr[" + i +"]/td[1]")).getText());
        }
        ArrayList<Integer> PromoteStudentListIntegerList= new ArrayList<Integer>(PromoteStudentList.size());
        for(String myInt : PromoteStudentList ){
            PromoteStudentListIntegerList.add(Integer.valueOf(myInt));
        }
        System.out.println(PromoteStudentListIntegerList);
        Thread.sleep(3000);

        actionClass.clickOnObject(this.Promotebtn);
        actionClass.clickOnObject(this.Savebtnpopup);
        Thread.sleep(3000);

        VerificationClass very = new VerificationClass(driver1, extentTest);
        very.verifyTextPresent(this.classfeildvalidation, "No Record Found");

        DatabaseFunctions DAB = new DatabaseFunctions(extentTest);
        conn = DAB.connect();
        statement = conn.createStatement();
        String students = "SELECT student_session.id, student_session.session_id, students.firstname, students.lastname, students.is_active, students.is_inactive, classes.class, students.admission_no, sections.id FROM `student_session` INNER JOIN students ON student_session.student_id = students.id INNER JOIN classes ON student_session.class_id = classes.id INNER JOIN sections ON student_session.section_id=sections.id WHERE student_session.session_id = '15' AND classes.class = '9th' AND sections.id= 10 AND student_session.is_inactive = 'no' AND students.id NOT IN( SELECT student_id FROM promot_student )";
        queryRs = statement.executeQuery(students);
        ArrayList<String> ListPromoteStudent1 = new ArrayList<String>();

        while (queryRs.next()) {
            String s1 = null;
            s1 = queryRs.getString("students.admission_no");
            System.out.println("Admission no. is " + s1);
            ListPromoteStudent1.add(queryRs.getString("students.admission_no"));
        }
        ArrayList<Integer> PromoteStudentListIntegerList1= new ArrayList<Integer>(ListPromoteStudent1.size());
        for(String myInt : ListPromoteStudent1 ){
            PromoteStudentListIntegerList1.add(Integer.valueOf(myInt));
        }
//        Collections.sort(PromoteStudentListIntegerList1);
        System.out.println(PromoteStudentListIntegerList1);
        System.out.println(PromoteStudentListIntegerList1.equals(PromoteStudentListIntegerList));
//        System.out.println(listNames.equals(listNames1));
        actionClass.CompareList(PromoteStudentListIntegerList,PromoteStudentListIntegerList1);

    }
    public void LeaveStudent()throws InterruptedException,IOException{
        ActionClass actionClass=new ActionClass(this.driver1,extentTest);
        actionClass.clickOnObject(this.ClickOnStudentInformation);
        Thread.sleep(3000);
        actionClass.clickOnObject(this.ClickOnPromoteStudent);
        actionClass.clickOnObject(this.classfeild);
        actionClass.clickOnObject(this.selectoption);
        actionClass.clickOnObject(this.sectionfeild);
        actionClass.clickOnObject(this.selectoptionforsection);
        actionClass.clickOnObject(this.searchbtn);
        actionClass.clickOnObject(this.Promoteinsessionclcik);
        actionClass.clickOnObject(this.SelectSession);
        actionClass.clickOnObject(this.PromoteClass);
        actionClass.clickOnObject(this.SelectclassforPromote);
        actionClass.clickOnObject(this.PromoteSession);
        actionClass.clickOnObject(this.SelectsectionforPromote);
        JavascriptExecutor jsetaskscore = (JavascriptExecutor) driver1;
        jsetaskscore.executeScript("scrollBy(0, 150)");
        actionClass.clickOnObject(this.Leavbtn);
         actionClass.clickOnObject(this.Promotebtn);
         actionClass.clickOnObject(this.Savebtnpopup);
         Thread.sleep(100);
         actionClass.clickOnObject(this.LeavingStudentSidemenu);
         actionClass.clickOnObject(this.LeavingStudentclass);
         actionClass.clickOnObject(this.LeavingStudentSelectclass);
         actionClass.clickOnObject(this.LeavingStudentSection);
         actionClass.clickOnObject(this.LeavingStudentSelectSection);
         actionClass.clickOnObject(this.LeavingSearch);
         actionClass.clickOnObject(this.SearchFeild);
         actionClass.setValueinTextbox(this.SearchFeild,"12220");

    }
}









