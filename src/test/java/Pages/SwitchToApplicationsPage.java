package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwitchToApplicationsPage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Applications')]")
    private WebElement Applicationlink;

    //navigating to application page
    public void navigate_applicationpage() throws Exception {

        //clicks on application menu
        Applicationlink.click();
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());
        Thread.sleep(5000);
        passFailscreenshot("application tab is clicked ");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Applications");
    }

    public SwitchToApplicationsPage(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
