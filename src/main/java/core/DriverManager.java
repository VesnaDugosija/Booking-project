package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private WebDriver driver;
    private static final DriverManager instance = new DriverManager();
    public static DriverManager getInstance(){

        return instance;
    }

    public WebDriver setDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("fireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
        driver.manage().window().maximize();
        return driver;
    }
    }


