package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class SubscriptionOfAPI extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Select Application...')]")
    private WebElement Applicationselection;

    @FindBy(id="application-list")
    private WebElement selectionlist;

    @FindBy(xpath = "//span[contains(text(),'My Applications')]")
    private WebElement applicationsavailable;

    @FindBy(xpath = "//span[contains(text(),'Unlimited')]")
    private WebElement tierselection;

    @FindBy(id="subscribe-button")
    private WebElement subscribe_btn;

    @FindBy(xpath = "//a[contains(text(),'Stay on this page')]")
    private WebElement stayonthispage_btn;

    public void subscribe_Application() throws Exception {

        //displays current Url of the web page
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //selecting the application name from dropdown
        Applicationselection.click();
        passFailscreenshot("selecting application");
        test.log(Status.PASS,"subscribe for application");

        //clicks on the first avaliable list
        driver.findElement(By.xpath("//span[contains(text(),"+TestBase.config.getProperty("subscribeApplicationName")+")]")).click();
        passFailscreenshot("selecting application");
        test.log(Status.PASS," Selected application name"+config.getProperty("subscribeApplicationName"));

        //tier selection
        tierselection.click();
        passFailscreenshot("selecting  tiers of application");
        test.log(Status.PASS," Selected  tiers osf the application ");

        //tier selection is specified in the config file
        driver.findElement(By.xpath("//span[contains(text(),"+TestBase.config.getProperty("tierselection_API")+")]")).click();
        passFailscreenshot("gold tier selection");
        test.log(Status.PASS," gold tiers of the application ");

        //click on subscribe button
        subscribe_btn.click();
        Thread.sleep(5000);
        passFailscreenshot("subscribe btn");
        test.log(Status.PASS," Subscribe button clicked ");

        Thread.sleep(5000);
        //clicks on stayonthispage button in the pop-up
        stayonthispage_btn.click();
        passFailscreenshot("stay on this page");
        test.log(Status.PASS," clicked on stay on this page ");


    }

    public SubscriptionOfAPI(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
