package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ForgotPassword extends TestBase {
    @FindBy(xpath = "//*[@id=\"mainLoginForm\"]/div[4]/div/a")
    private WebElement ForgotPassword_btn;

    @FindBy(xpath = "/html/body/section[1]/nav/a")
    private WebElement GoTostore1;

    @FindBy(xpath = "//*[@id=\"btn-login\"]")
    private WebElement SignIn_link;

    @FindBy(id="username")
    private WebElement Email_field;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement ForgotCancel_btn;

    @FindBy(xpath = "//button[contains(text(),'Reset Password')]")
    private WebElement Resetpwd_btn;

    @FindBy(xpath = "//input[@id='reset-password']")
    private WebElement resetpwdfield1;

    @FindBy(xpath = "//input[@id='reset-password2']")
    private WebElement confirmpwd;

    //@FindBy(xpath = "//button[contains(text(),'Submit')]")
    @FindBy(id="registrationSubmit")
    private WebElement submitbtn;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement closebutton;



    public void ForgotPassword_cancel() throws Exception {

        //reading sourceURL from config file
        driver.get(TestBase.config.getProperty("sourceURl"));

        //reads and displays pageTitle
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        //clicks on Gotostore
        GoTostore1.click();
        test.log(Status.PASS, "GoToStore is clicked");
        passFailscreenshot("Go to Store is clicked");
        Thread.sleep(5000);

        //clicks on signIn link
        SignIn_link.click();
        passFailscreenshot("SignIn link is clicked");
        test.log(Status.PASS, "Signlink is clicked");

        //clicks on Forgotpassword
        ForgotPassword_btn.click();
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());
        passFailscreenshot("Forgotpassword  is clicked");
        test.log(Status.PASS, "Forgotpassword is clicked");

        //send data to email from config file
        Email_field.sendKeys(TestBase.config.getProperty("Forgot_email"));
        passFailscreenshot("Forgotpassword  entered");
        test.log(Status.PASS, "Entered forgot email");

        //clicks on Cancel button
        ForgotCancel_btn.click();
        passFailscreenshot("Forgotpassword-cancel");
        test.log(Status.PASS, "clicked on cancel button");


    }
    public void ForgotPassword_ResetPassword() throws Exception {

        //clicks on ForgotPassword
        ForgotPassword_btn.click();
        passFailscreenshot("Forgotpassword  is clicked");
        test.log(Status.PASS, "Forgotpassword is clicked");

        //reads the currentUrl of the webpage
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //send data to email from config file
        Email_field.sendKeys(TestBase.config.getProperty("Forgot_email"));
        passFailscreenshot("Forgotpassword  entered");
        test.log(Status.PASS, "Entered forgot email");

        //click on reset button
        Resetpwd_btn.click();
        passFailscreenshot("Forgotpassword-cancel");
        test.log(Status.PASS, "clicked on Reset password  button");

        //clicks on close button in the pop-up
        closebutton.click();
    }

    //performing reset password opertions from gmail
    public void Resetpassword_gmail() throws Exception {

        //reads current URl and displays
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //send data to password field from config file
        resetpwdfield1.sendKeys(TestBase.config.getProperty("resetpwd"));
        passFailscreenshot("new password entered");
        test.log(Status.PASS, "Entered new password");

        //send data to confirm password fields
        confirmpwd.sendKeys(TestBase.config.getProperty("resetpwd"));
        passFailscreenshot("confirmPassword");
        test.log(Status.PASS, "Entered confirm password");
        Thread.sleep(5000);

        //verifying whether button is displayed or not
       boolean flag= submitbtn.isDisplayed();
       System.out.println(flag);

       //scroll down till the element is viewed
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submitbtn);
        passFailscreenshot("submit button clicked");
        test.log(Status.PASS, "submit button clicked");

        //clicked on submit button
       submitbtn.click();

       //clicks on close button in the pop-up
       //closebutton.click();



    }
    public ForgotPassword(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}

