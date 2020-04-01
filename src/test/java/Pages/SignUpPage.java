package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignUpPage extends TestBase {
    @FindBy(linkText = "   Register")
    private WebElement RegisterforFree;
    @FindBy(xpath = "/html/body/section[1]/nav/a")
    private WebElement GoTostore1;
    @FindBy(xpath="//*[@id=\"register-link1\"]/span")
    private WebElement SignUp;
    @FindBy(id="username")
    private WebElement email;
    @FindBy(id="registrationSubmit")
    private WebElement proceedToSelfRegister;
    @FindBy(xpath = "//*[@id=\"register\"]/div/div/div/div[2]/div[3]/input")
    private WebElement FirstName_field;
    @FindBy(xpath = "//*[@id=\"register\"]/div/div/div/div[2]/div[4]/input")
    private WebElement LastName_field;
    @FindBy(id= "password")
    private WebElement Password_field;
    @FindBy(id = "password2")
    private WebElement ConfirmPassword_field;
    @FindBy(xpath = "//label[contains(text(),' Country ')]/following::*[position()=1]")
    private WebElement country_field;
    @FindBy(xpath = "//label[contains(text(),' Mobile')]/following::*[position()=1]")
    private WebElement Mobile_field;
    @FindBy(xpath = "//label[contains(text(),' Department ')]/following::*[position()=1]")
    private WebElement Department_field;
    @FindBy(xpath = "//label[contains(text(),' IM ')]/following::*[position()=1]")
    private WebElement Im_field;
    @FindBy(xpath = "//label[contains(text(),' URL ')]/following::*[position()=1]")
    private WebElement URL_field;
    @FindBy(xpath = "//label[contains(text(),'Telephone ')]/following::*[position()=1]")
    private WebElement telephone_filed;

    @FindBy(xpath = "//label[contains(text(),' Role ')]/following::*[position()=1]")
    private WebElement role_field;
    @FindBy(xpath = "//label[contains(text(),' Enterprise Number')]/following::*[position()=1]")
    private WebElement  CompanyNumber_field;
    @FindBy(xpath = "//label[contains(text(),'Organisation')]/following::*[position()=1]")
    private WebElement organization_field;
    @FindBy(xpath = "//label[contains(text(),' Mobile')]/following::*[position()=1]")
    private WebElement contact_field;
    @FindBy(xpath = "//*[@id=\"register\"]/div/div/div/div[3]/div[2]/div[1]/label/input")
    private WebElement Acceptance_chkbx;
    @FindBy(id="registrationSubmit")
    private WebElement registration_btn;

    @FindBy(xpath = "//*[@id=\"registrationSubmit\"]")
    private WebElement closeSuccessRegistration_btn;


    public void SignupPage(String email1,String FirstName,String LastName,String Password,String confirmPassword,String contactnumber,String Companyenterprisenumber,String organizationname,ExtentTest test) throws Exception {
        this.test = test;

        //Loding home page and displays pageTitle
        driver.get(TestBase.config.getProperty("sourceURl"));
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        //Attempting GoToStore click
        /*GoTostore1.click();
        test.log(Status.PASS, "GoToStore is clicked");
        passFailscreenshot("Go to Store is clicked");*/

        //performing click operation on signup
        SignUp.click();
        test.log(Status.INFO, "Sign up is linked");
        passFailscreenshot("Sign up link is clicked");

        //logs information which server it directs
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //validating create your account text is displayed
        String actualString=driver.findElement(By.xpath("//h3[contains(text(),'Create your Account')]")).getText();
        System.out.println(actualString);
        s_Assert.assertEquals(actualString,"Create your Account");

        //sending data to email field from excel file
        email.sendKeys(email1);
        passFailscreenshot("Email is entered"+email1);
        test.log(Status.INFO, "Entered email_field :" + email1);


        //passFailscreenshot("Actual Screen" +actualString);
        //test.log(Status.PASS,"Verifying Signup page is loaded"+s_Assert);

        //clicking on proceed to self Register
        proceedToSelfRegister.click();
        passFailscreenshot("proceed  link is clicked");
        test.log(Status.INFO, "clicking proceed to self Register");

        //sending data to FirstName from excel
        FirstName_field.sendKeys(FirstName);
        passFailscreenshot("FirstName is entered"+FirstName);
        test.log(Status.INFO, "Entered name in FirstName_field :" );

        //sending data to LastName from excel
        LastName_field.sendKeys(LastName);
        passFailscreenshot("LastName is entered"+LastName);
        test.log(Status.INFO, "Entered lastName in lastName_field :" );

        //sending data to Password from excel
        Password_field.sendKeys(Password);
        passFailscreenshot("Password is entered"+Password);
        test.log(Status.INFO, "Entered password in password_field :" );

        //sending data to confirmPassword from excel
        ConfirmPassword_field.sendKeys(confirmPassword);
        passFailscreenshot("ConfirmPassword is entered"+confirmPassword);
        test.log(Status.INFO, "Entered confirmPassword in confirmPassword_field :" );

        //sending data to contact field from excel
        contact_field.sendKeys(contactnumber);
        passFailscreenshot("Contact Number is entered"+contactnumber);
        test.log(Status.INFO, "Entered contactNumber in contact_field :"+contactnumber );

        //sending data to companyNumber from excel
        CompanyNumber_field.sendKeys(Companyenterprisenumber);
        passFailscreenshot("Enterprise number is entered"+Companyenterprisenumber);
        test.log(Status.INFO, "Entered  comany Enterprisenumber_field :" +Companyenterprisenumber );

        //sending data to organization field from excel
        organization_field.sendKeys(organizationname);
        passFailscreenshot("organization name is entered"+organizationname);
        test.log(Status.INFO, "Entered organization name in organization_field :"+organizationname );



        //click on chk box
        Acceptance_chkbx.click();
        passFailscreenshot("chkbox");
        test.log(Status.INFO, "clicked on checkbox" );

        //click on registration button
        registration_btn.click();
        passFailscreenshot("registration button is clicked");
        test.log(Status.INFO,"registration buton is cliked");
        Thread.sleep(500);

        //perform operations on the pop-up
        closeSuccessRegistration_btn.click();
        registration_btn.click();
        passFailscreenshot(" Successful registration button pop-up is viewed");

    }

    public SignUpPage(){

        PageFactory.initElements(driver,this);
    }

}
