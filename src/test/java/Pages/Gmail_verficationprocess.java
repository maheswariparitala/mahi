package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Gmail_verficationprocess extends TestBase {

    @FindBy(id="identifierId")
    private  WebElement emailfield;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/span/span")
    private   WebElement nextbtn;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private   WebElement password_field;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/span")
    private   WebElement pwd_nxtbtn;

    @FindBy(xpath = "//span[@class='bA4']")
    List<WebElement>  emailthreads;

    @FindBy(xpath = "//span[contains(text(),'WSO2 - Password Reset')]")
    private WebElement subject_email;

    @FindBy(linkText = "Confirm Account")
    private WebElement confirmlink;

    @FindBy(xpath = "//a[contains(text(),'Reset Password')]")
    private WebElement resetpwdlink;

    @FindBy(xpath = "//h1")
    private WebElement headingofEmail;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement closebutton;

    //performing gmail actions for account confirmation and reset password
    public   void gmail_actions() throws Exception {

        //call gmail server
        driver.get("http://www.gmail.com");

        //displays currenturl in the log
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());
        passFailscreenshot("gmail  is clicked");
        test.log(Status.PASS, "directed to gmail ");

        //send data to email field
        emailfield.sendKeys(TestBase.config.getProperty("Forgot_email"));
        passFailscreenshot("email id   is entered");
        test.log(Status.PASS, "Email entered");

        //click on next button
        nextbtn.click();
        passFailscreenshot("next button is clicked");
        test.log(Status.PASS, "next button");

        //send data to password field
        password_field.sendKeys(TestBase.config.getProperty("password"));
        passFailscreenshot("password  is clicked");
        test.log(Status.PASS, "password is clicked");

        //clicks on nxt buuton
        pwd_nxtbtn.click();
        passFailscreenshot("pwdnxt button clicked");
        test.log(Status.PASS, "pwdnxt_btn");
        Thread.sleep(5000);

        //performing loop actions till the marketplace email is visible
        for(int i=0;i<emailthreads.size();i++){
            System.out.println(emailthreads.size());
            if(emailthreads.get(i).getText().contains("WSO2 - Password Reset")){
                emailthreads.get(i).click();
                passFailscreenshot(" clicking on email");
                test.log(Status.PASS, "Email_link");
                System.out.println("email clicked");
                break;

            }
            else if (emailthreads.get(i).getText().contains("Account Confirmation")){
                emailthreads.get(i).click();
                passFailscreenshot(" clicking on email");
                test.log(Status.PASS, "Email_link");
                System.out.println("email clicked");
                break;
            }




        }
        Thread.sleep(5000);

        //getting heading of email
        String heading=headingofEmail.getText();

        //depends on heading it performs below operations,whether account confirmation or password reset
        if(heading.contains("Account Confirmation")){
                confirmlink.click();
                Thread.sleep(5000);
            passFailscreenshot("Confirmation link is  clicked");
            test.log(Status.PASS, "confirmationlink");
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            closebutton.click();
            passFailscreenshot("close button clicked");
            test.log(Status.PASS, "Close button clicked");

        }
        else{
            resetpwdlink.click();
            passFailscreenshot("reset pwd link clicked");
            test.log(Status.PASS, "reset_pwdlink");
            //switching from one tab to another tab
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));


        }


    }

    public Gmail_verficationprocess(ExtentTest test){

        this.test=test;
        PageFactory.initElements(driver,this);

    }
}
