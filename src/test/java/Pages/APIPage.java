package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class APIPage extends TestBase {
    @FindBy(xpath = "/html/body/section[1]/nav/a")
    private WebElement GoTostore;
    @FindBy(xpath = "//*[@id=\"left-sidebar\"]/nav/ul/li[2]/a")
    private WebElement APILInk;

    @FindBy(xpath ="//button[contains(text(),'View more')]")
    private WebElement Lulalend_morebtn;

    @FindBy(xpath = "//button[contains(text(),'View more')]/following::button[1]")
    private WebElement PayU_morebtn;

    @FindBy(xpath = "//button[contains(text(),'View more')]/following::button[2]")
    private WebElement ThisIsme_morebtn;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/button")
    private WebElement view_btn;

    public void navigate_APItab() throws Exception {

        //reads the SourceURl from config file
        driver.get(TestBase.config.getProperty("sourceURl"));

        //clicks on GotoStore
        GoTostore.click();
        test.log(Status.PASS, "Go to Store is clicked");
        passFailscreenshot("GoTostore");

        //clicks on API which mentioned in the config file
        WebElement text = driver.findElement(By.xpath("//a[contains(text()," + TestBase.config.getProperty("APIName") + ")]"));

        //verifying API name is displayed and click on the api
        boolean flag = text.isDisplayed();
        System.out.println("TestJsonPlaceholder is visible on the page:" + flag);
        text.click();
        passFailscreenshot("specifiedapi");
        test.log(Status.PASS, "clicked on " + TestBase.config.getProperty("APIName"));
        Thread.sleep(5000);

    }

        public APIPage(ExtentTest test){

        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
