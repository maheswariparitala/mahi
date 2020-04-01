package TestSuite;

import BaseClass.TestBase;
import Pages.*;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MarketplaceHomePage extends TestBase {
    HomePage home;
    SignUpPage signup;
    SignInPage SignIn;
    SwitchToApplicationsPage switchapplication;
    ApplicationPage application;
    ApplicationListLink applicationlist;
    ViewapplicationPage viewapplication;
    EditApplicationDetailsPage editApplication;
    DeleteapplicationPage deleteapplication;
    SandboxKeysGeneration sandbox;
    Signout out;
    APIPage selectApi;
    ForgotPassword forgotPassword;
    Gmail_verficationprocess gmailverification;
    SubscriptionOfAPI subscription;

    @Test(priority = 1,description = "validating home page")
    public void homepage() throws Exception {
       test=extent.createTest("homepage","Homepage verification started");
        home = new HomePage();
        home.VerifyHomepagelinks(test);
    }
   //using excel  required need to pass data provider along with test annotation

    @Test (dataProvider = "Register_fields",priority = 2,description = "Performing Registration with valid details")
    public void test_signupPage(String email,String FirstName,String LastName,String Password,String confirmPassword,String Companyenterprisenumber,String organizationname,String contactnumber) throws Exception {
        test = extent.createTest("SignupPage", "Signup Page");
        signup = new SignUpPage();
        gmailverification=new Gmail_verficationprocess(test);
        try {
            signup.SignupPage(email,FirstName, LastName, Password, confirmPassword, Companyenterprisenumber, organizationname, contactnumber, test);
            Thread.sleep(10000);

        } catch (Exception e) {
            e.getStackTrace();
        }
        gmailverification.gmail_actions();
    }

    @Test(priority = 3)
    public void  test_ForgotPassword() throws Exception {
        test=extent.createTest("ForgotPassword","Forgotpassword actions ");
        forgotPassword=new ForgotPassword(test);
        gmailverification=new Gmail_verficationprocess(test);
        forgotPassword.ForgotPassword_cancel();
        forgotPassword.ForgotPassword_ResetPassword();
        Thread.sleep(5000);
        gmailverification.gmail_actions();
        Thread.sleep(500);
        forgotPassword.Resetpassword_gmail();


    }
     @Test(dataProvider = "SignIn_values",priority = 4,description = "Performing SignIn Actions")
    public void test_SignInPage(String Username,String Password){
        test=extent.createTest("SignInPage","SignIn Page");
        SignIn=new SignInPage(test);
         try {
             SignIn.SignIn_Actions(Username,Password);
         } catch (Exception e) {
             e.printStackTrace();
         }

     }

    @Test(priority = 5,dependsOnMethods = "test_SignInPage")
    public void test_SwitchToApplicationsPage() throws Exception {
        test=extent.createTest("  application page "," Loading applicationpage");
        switchapplication=new SwitchToApplicationsPage(test);
        switchapplication.navigate_applicationpage();

    }

     @Test(priority = 6,dependsOnMethods = "test_SwitchToApplicationsPage")
    public void test_ApplicationPage() throws Exception {
         test=extent.createTest(" Add application","Adding a new application process");
         application=new ApplicationPage(test);
         application.setAddapplication_Page();

    }

    @Test(priority = 7,dependsOnMethods = "test_ApplicationPage")
    public void test_sandboxgenerateKeysPage() throws Exception {
        test=extent.createTest(" sandboxkeys"," sandboxkeys generation flow");
        sandbox=new SandboxKeysGeneration();
        sandbox.sandboxKeygeneration(test);

    }

    @Test(priority = 8,dependsOnMethods = "test_ApplicationPage")
    public void test_ApplicationListLink() throws Exception {
        test=extent.createTest("applicationList button","clicking on Application list button");
        applicationlist=new ApplicationListLink(test);
        applicationlist.setApplicationlink();

    }

    @Test(priority = 9,dependsOnMethods = "test_ApplicationListLink")
    public void test_ViewapplicationPage() throws Exception {
        test=extent.createTest("View application"," view applicationpage started");
        viewapplication=new ViewapplicationPage(test);
        viewapplication.viewSpecified_application();

    }
    @Test(priority = 10,dependsOnMethods = "test_ApplicationListLink")
    public void test_EditApplicationPage() throws Exception {
        test=extent.createTest("Editapplication Actions","Edit Aaplication actions");
        editApplication=new EditApplicationDetailsPage(test);
        editApplication.edit_application();

    }
    @Test(priority = 11,dependsOnMethods = "test_ApplicationListLink")
    public void test_APIPage() throws Exception {
        test=extent.createTest("API of the  user","List of API's ready to use");
        selectApi=new APIPage(test);
        selectApi.navigate_APItab();

    }
    @Test(priority=12,dependsOnMethods ="test_APIPage")
    public void test_subscriptionofAPI() throws Exception {
        test=extent.createTest("Subscription of the  application","Subscription of Application process");
        subscription = new SubscriptionOfAPI(test);
        subscription.subscribe_Application();

    }
    @Test(priority = 13,dependsOnMethods = "test_subscriptionofAPI")
    public void test_DeleteapplicationPage() throws Exception {
        test=extent.createTest("Delete application","Delete application actions  started");
        deleteapplication=new DeleteapplicationPage(test);
        deleteapplication.delete_application();

    }



     @Test(priority = 14,dependsOnMethods = "test_DeleteapplicationPage")
    public void test_Signout() throws Exception {
        test=extent.createTest("Signout of the  application","User is quit from the application");
        out=new Signout(test);
        out.SignOut_action();

     }




}
