package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest{

    static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getInstance().setDriver("chrome");
        softAssert = new SoftAssert();
        driver.get("https://www.booking.com/index.sr.html");

    }
    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
    public WebDriver getDriver(){

        return driver;
    }


}

