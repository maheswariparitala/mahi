package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInPage  extends TestBase {
    @FindBy(xpath = "/html/body/section[1]/nav/a")
    private WebElement GoTostore1;
    @FindBy(id= "logon")
    private WebElement SignIn_link;
    @FindBy(id = "username")
    private WebElement UserName_field;
    @FindBy(id = "password")
    private WebElement Password_field;
    @FindBy(id = "loginBtn")
    private WebElement login_btn;
    @FindBy(xpath = "//*[@id=\"left-sidebar\"]/nav/ul/li[2]/a")
    private WebElement Applicationlink;

    @FindBy(xpath = "/html/body/div[2]/div[9]")
    private WebElement popup_close;


    public void SignIn_Actions(String Username,String Password) throws Exception {

        //reads Url from config file
        driver.get(TestBase.config.getProperty("sourceURl"));

        //reads pageTiltle and displays
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        //clicking on GoToStore
       /* GoTostore1.click();
        test.log(Status.PASS, "GoToStore is clicked");
        passFailscreenshot("Go to Store is clicked");
        Thread.sleep(5000);*/

        //click on signIn link
        SignIn_link.click();
        passFailscreenshot("SignIn link is clicked");
        test.log(Status.PASS, "Signlink is clicked");
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //send data to UserName field from excel
        UserName_field.sendKeys(Username);
        System.out.println("Username Entered1");
        passFailscreenshot("Username is Entered"+Username);
        System.out.println("Username Entered2");
        test.log(Status.PASS,"Username is Entered :"+Username);

        //send data to Password filed from excel
        Password_field.sendKeys(Password);
        passFailscreenshot("Password is Entered"+Password);
        test.log(Status.PASS,"Password is Entered :"+Password);

        //Attempting login btn
        login_btn.click();
        passFailscreenshot("Login btn is clicked");
        test.log(Status.PASS,"Login button clicked");
        Thread.sleep(5000);
       // popup_close.click();
        passFailscreenshot("pop-up  is closed");
        test.log(Status.PASS,"pop-up is closed");

        //validating API Catalog  text is displayed on the store page
        try{
            String actualString=driver.findElement(By.xpath("//h2[contains(text(),'API Catalog')]")).getText();

            s_Assert.assertTrue(actualString.contains("API Catalog"));

        }
        catch (Exception e){
            test.log(Status.INFO,e.getMessage());
        }
    }
    public SignInPage(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}

