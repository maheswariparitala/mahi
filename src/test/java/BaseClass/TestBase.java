package BaseClass;

import Utilities.Constants;
import Utilities.ExcelUtilities.ReadExcelFile;
import Utilities.ExcelUtilities.ScreenshotUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.apache.commons.mail.EmailException;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.aventstack.extentreports.Status.*;

public class TestBase {

    public static Properties config = null;
    public static WebDriver driver = null;
    public static SoftAssert s_Assert = null;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static final String testDataExcelFileName = "Testdata.xlsx";
    public String concatenate = ".";

    public TestBase() {
        initConfig();
    }

    @BeforeSuite
    public void Extentreportssetup() {
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "./reports/openAPIMarketplace.html");
        htmlReporter = new ExtentHtmlReporter("./reports/openAPIMarketplace.html");
        htmlReporter.setAppendExisting(false);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //setupsourceURL();
        initBrowser();


    }

    @BeforeClass
    public void setupsourceURL() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(config.getProperty("sourceURl"));
        System.out.println("SourceURL");

    }

    @AfterSuite
    public void closebrowser() throws Exception {
        extent.flush();
        //EmailableReport.Emailattachments();
        //javamailAPI.reportMailAttachment();
        //System.out.println("Email Sent ");
        driver.close();
    }

    @AfterMethod
    public void resultStatus(ITestResult iTestResult) {
        if(iTestResult.getStatus()==ITestResult.SUCCESS){
            test.pass("test is passed :"+iTestResult.getTestName());
        }
        else if(iTestResult.getStatus()==ITestResult.FAILURE){
            test.fail("test is Failed "+iTestResult.getThrowable());
        }
        else {
            test.skip("test is skipped" +iTestResult.getTestName());
        }


    }



    public static WebDriver initBrowser() {
        initConfig();
        driver = null;
        if (config.getProperty("testbrowser").equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (config.getProperty("testbrowser").equalsIgnoreCase("chrome")) {
            //it intializes chromedriver  from cloud no need to store chrome driver locally
            //ChromeDriverManager Manager = new ChromeDriverManager();
            //Manager.getInstance().setup();

            System.setProperty ( "webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver-80");
            System.out.println(System.getProperty("user.dir"));
            //System.setProperty("webdriver.chrome.driver","//Users//abmpa2g//Documents//Documents//OAB_Marketplace//src//main//resources//chromedriverupdate.exe");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();


        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        return driver;
    }

    public static void initConfig() {
        //intialize the config and assertions variable
        config = new Properties();
        s_Assert = new SoftAssert();

        try {
            //Reading properties file path from constants calss
            FileInputStream readConfig = new FileInputStream(Constants.Config_File_Path);
            config.load(readConfig);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    @DataProvider(name = "Register_fields")
    public static Object[][] Register_fields() {
        Object[][] data = ReadExcelFile.getTestData("Register_fields");

        return data;
    }

    @DataProvider(name = "SignIn_values")
    public static Object[][] SignIn_fields() {
        Object[][] data = ReadExcelFile.getTestData("SignIn_values");

        return data;
    }


    //newly added code of extent reports sharing
    public  void passFailscreenshot(String name) throws IOException {
        String screenshotName = concatenate + ScreenshotUtility.getScreenshot(driver, name);
        screencapture("testname", screenshotName);
    }

    public static Object screencapture(String logdetails, String imgpath) throws IOException {
        //report with snapshot

        test.log(INFO, "testing", MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());

        return test;
    }



}


