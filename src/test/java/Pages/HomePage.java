package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static Utilities.ExcelUtilities.ScreenshotUtility.getScreenshot;

public class HomePage extends TestBase {
    @FindBy(xpath = "/html/body/section[1]/nav/a")
     private WebElement GoTostore;
    @FindBy(linkText = "Getting started")
     private WebElement GettingStarted; 
    @FindBy(linkText = "Register for free")
     private WebElement RegisterforFree;  
    @FindBy(linkText = "View More")
     private WebElement ViewMorebutton;       
    
    String PageTitle=driver.getTitle();
   

    public void VerifyHomepagelinks(ExtentTest test) throws IOException {
        this.test=test;

        //displays page title
        System.out.println(PageTitle);

        //retrieves current URL and displays it
        String Url=driver.getCurrentUrl();
        test.log(Status.PASS,"Current URL:"+Url);
        test.log(Status.PASS,"Environment details"+config.getProperty("sourceURl"));

        //Verifying GotoStore link
        /*GoTostore.click();
        test.log(Status.PASS,"Go to Store is clicked");
        passFailscreenshot("GoTostore");
        test.log(Status.PASS,"Goto Store is clicked");
        driver.get(TestBase.config.getProperty("sourceURl"));*/

        //verifying Getting started link on home page
        GettingStarted.click();
        test.log(Status.PASS,"Getting started is clicked");
        passFailscreenshot("Getting Started");
        driver.navigate().back();

        //Verfying Register for free directions
        /*RegisterforFree.click();
        test.log(Status.PASS,"register for free is clicked");
        passFailscreenshot("register for free is clicked");
        driver.navigate().back();*/

        //validating the directions of ViewMore button
        ViewMorebutton.click();
        test.log(Status.PASS,"view more button  is clickable");
        passFailscreenshot("View more button is clicked");

        //validating using assertions whether api directs to correct page
        //String actualString=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/h2/span/text()")).getText();
        //s_Assert.assertTrue(actualString.contains("PayU"));

    }
    


    public HomePage(){

        PageFactory.initElements(driver,this);
    }
}

