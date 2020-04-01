package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Signout extends TestBase {

    @FindBy(xpath="/html/body/header/div/ul/li/a")
    private WebElement useraccount_link;

    @FindBy(xpath = "//*[@id=\"logout-link\"]")
    private WebElement signOut_btn;

    public void SignOut_action() throws Exception {

        //Retrieving list of elements from user account drop down and storing in a link
        WebElement link=useraccount_link;

        //click on the link element
        link.click();
        Thread.sleep(500);
        passFailscreenshot("useraccount");
        test.log(Status.PASS,"clicked on user account");

        //clicking on Signout button
        WebElement dropdown=signOut_btn;
        dropdown.click();
        passFailscreenshot("sign out");
        test.log(Status.PASS,"clicked on Sign out button");
    }

    public Signout(ExtentTest test){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
