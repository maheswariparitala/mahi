package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteapplicationPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"btn-primary\"]")
    private WebElement deleteYes_btn;
    SwitchToApplicationsPage link;

    //performing  delete operation on a specified  application button
    public void delete_application() throws Exception {

        //reads currentUrl of the webpage and displays
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //calling applicationlistlink page  methods to perform delete operations
        link=new SwitchToApplicationsPage(test);
        link.navigate_applicationpage();

        //deleting specific application mentioned in the config file
        driver.findElement(By.xpath("//a[contains(text(),"+TestBase.config.getProperty("deleteapplication")+")]/parent::td//following-sibling::td[4]/a[3]")).click();
        Thread.sleep(5000);
        test.log(Status.PASS," deleted specified application"+config.getProperty("deleteapplication"));
        passFailscreenshot("delebtn is clicked ");

        //clicking on delete button
        deleteYes_btn.click();
        Thread.sleep(5000);
        passFailscreenshot("delete_Yesbtn is clicked ");

    }

    public DeleteapplicationPage(ExtentTest test){

        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
