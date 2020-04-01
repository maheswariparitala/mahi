package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationListLink extends TestBase {
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[1]/a")
    private WebElement applicationlist_btn;

    //navigating to list of applications
    public void setApplicationlink() throws Exception {

        //reads currentUrl and displays it in logs
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //clicks on application link
        applicationlist_btn.click();
        Thread.sleep(5000);
        passFailscreenshot("application list btn");
        test.log(Status.INFO,"Application list  button is clicked to verify list of the applications available");

    }

    public ApplicationListLink(ExtentTest test){

        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
