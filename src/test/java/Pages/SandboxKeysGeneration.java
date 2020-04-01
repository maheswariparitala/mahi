package Pages;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SandboxKeysGeneration extends TestBase {
    @FindBy(xpath = "//*[@id=\"sandbox-keys-tab\"]/a")
    private WebElement sandboxtab;

    @FindBy(xpath = "//*[@id=\"sandbox\"]/div[2]/div/form/div[2]/div/input")
    private WebElement accesstokenperiod_field;

    @FindBy(xpath = "//*[@id=\"sandbox\"]/div[2]/div/form/button")
    private WebElement generateKeys_btn;


    public void sandboxKeygeneration(ExtentTest test) throws Exception {

        //clicks on sandbox
        sandboxtab.click();
        passFailscreenshot(" sandbox cliked");
        test.log(Status.PASS,"Attempted sandbox tab");

        //reads the currenturl of the webpage
        test.log(Status.PASS,"Current URL:"+driver.getCurrentUrl());
        Thread.sleep(5000);

        //clear the default text
        accesstokenperiod_field.clear();
        test.log(Status.PASS,"clear the existing token value");

        //send data to token from config file
        accesstokenperiod_field.sendKeys(TestBase.config.getProperty("acesstokenperiodValue"));
        passFailscreenshot(" entered token value");
        test.log(Status.PASS,"Enter token period value");

        //click generatekeys button
        generateKeys_btn.click();
        Thread.sleep(5000);
        passFailscreenshot("generateKeys button clicked");
        test.log(Status.PASS,"Clicked on generate keys button");

    }
    public SandboxKeysGeneration(){
        this.test=test;
        PageFactory.initElements(driver,this);
    }
}
