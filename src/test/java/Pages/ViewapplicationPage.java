package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ViewapplicationPage extends TestBase {
    //performing view application logic
    public void viewSpecified_application() throws Exception {

        //displaying currentUrl of the website
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //displaying view operations  on the specified application in the config file
        driver.findElement(By.xpath("//a[contains(text(),"+TestBase.config.getProperty("viewapplication")+")]/parent::td//following-sibling::td[4]/a[1]")).click();
        Thread.sleep(5000);
        passFailscreenshot("view application");
        test.log(Status.PASS,"application is viewed"+config.getProperty("viewapplication"));

    }

    public ViewapplicationPage(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
