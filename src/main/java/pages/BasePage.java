package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;


    public BasePage (WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
        faker = new Faker();

    }



    protected WebElement getElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected void clickOnElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected String getTextFromElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }
    protected void getAndClickOnRandomElement(By locator) {
//            Random random = new Random();
//            List<WebElement> list = driver.findElements(locator);
//            int randomElement = random.nextInt(list.size());
//            list.get(randomElement).click();

        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        //String randomPriceString = list.get(randomElement).getText();
       // String numberOnly= randomPriceString.replaceAll("[^0-9]", "");
       // double actualPrice = Integer.parseInt(numberOnly);
       // list.get(randomElement).click();
        return;

        }

//        protected void getAndClickOnListElement(By locator){
//            List<WebElement> list = driver.findElements(locator);
//            Random random = new Random();
//            int randomElement = random.nextInt(list.size());
//            return;
//        }

    protected void selectNumberFiled(By locator){
        WebElement numberField = getElement(locator);
        numberField.click();
        Select selectNumberFiled = new Select(numberField);
        selectNumberFiled.selectByValue("1");
        return;
    }

    protected double getAmountByRegex(String value){
        return Double.parseDouble(value.replaceAll("[\\D]", ""));


    }


    }


