package Utilities.ExcelUtilities;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class MergedDataProviders {

    @DataProvider(name = "Testdata")
    public static Object[][] testdata ()  {

        Object[][] data= ReadExcelFile.getTestData("email_fields");

        return data;
    }
}
