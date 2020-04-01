package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.io.IOException;

public class ApplicationPage extends TestBase {
    @FindBy(xpath = "/html/body/section[1]/nav/a")
    private WebElement GoTostore1;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li/a")
    private WebElement addapplication_btn;
    @FindBy(id = "application-name")
    private WebElement applicationname_field;
    @FindBy(id="application-add-button")
    private WebElement applicationadd_btn;

    //Adding a new application logic
    public void setAddapplication_Page() throws Exception{

        //displays currentUrl of the web page
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //clicks add application button
        addapplication_btn.click();
        test.log(Status.INFO,"Add application button is clicked");
        passFailscreenshot("application tab is clicked ");

        //send data to  application name from config file
        applicationname_field.sendKeys(TestBase.config.getProperty("Applicationname"));
        passFailscreenshot("Entered application name");
        test.log(Status.INFO,"Application Name Entered:"+config.getProperty("Applicationname"));

        //clicks on add button
        applicationadd_btn.click();
        passFailscreenshot("application add btn");
        test.log(Status.INFO,"Add  button is clicked to crate application");
    }

    //constructor to pass all the objects
    public ApplicationPage(ExtentTest test ){

        this.test = test;
        PageFactory.initElements(driver,this);
    }
}
