package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditApplicationDetailsPage extends TestBase {
    @FindBy(id="description")
    private WebElement description_field;

    @FindBy(id="tokenType")
    private WebElement tokenSelection;

    @FindBy(id="application-edit-button")
    private WebElement updateApplication_btn;
    ApplicationListLink link;

    //performing edit operations
    public void edit_application() throws Exception {

        //displaying currenturl in the log file of the report
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());

        //calling applicationlistlink page  methods to perform delete operations
        link=new ApplicationListLink(test);
        link.setApplicationlink();

        //edit specific application mentioned in the config file
        driver.findElement(By.xpath("//a[contains(text(),"+TestBase.config.getProperty("editapplication")+")]/parent::td//following-sibling::td[4]/a[2]")).click();
        Thread.sleep(5000);
        passFailscreenshot("Edit application");
        test.log(Status.PASS,"Edit application"+config.getProperty("editapplication"));

        //clear the text in the description field
        description_field.clear();

        //Type data in description field
        description_field.sendKeys(" this is updated by automation code");
        passFailscreenshot("Edit application description");
        test.log(Status.PASS,"Edit application"+config.getProperty("editapplication"));

        //selecting tokentype selection from dropdown
        Select sel= new Select(tokenSelection);
        //sel.selectByVisibleText("JWT");
        //passFailscreenshot("Edit tokentype ");
        //test.log(Status.PASS,"Edit  token type application"+config.getProperty("editapplication"));

        //click on update button
        updateApplication_btn.click();
        passFailscreenshot("Edit application");
        test.log(Status.PASS,"updated application Successfully");


    }

    public EditApplicationDetailsPage(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
