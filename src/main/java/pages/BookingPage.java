package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class BookingPage extends BasePage{

    By destinationField = By.cssSelector("input[class='c-autocomplete__input sb-searchbox__input sb-destination__input']");
    By kopFiled = (By.cssSelector("li[data-i='0']"));
    By calendarFiled = By.xpath("//div[@class='sb-date-field b-datepicker']");
    //By checkInDateFiled = By.xpath("//td[@class='bui-calendar__date']/span[@aria-label='1 juni 2022']");
    By checkInDateFiled = By.xpath("//td[@data-date='2022-06-01']");
    //By checkOutDateFiled = By.xpath("//td[@class='bui-calendar__date']/span[@aria-label='2 juni 2022']");
    By checkOutDateFiled = By.xpath("//td[@data-date='2022-06-02']");
    By searchButtonFiled = By.xpath("//button[@type='submit']");
    By breakfastIncludedCheckField = By.xpath ("//div[text()='Doručak uključen']");
   // By breakfastIncludedFlagField = By.cssSelector("div[class='a53696345b']");
    By actualPriceApartmentField = By.xpath("//div[@data-testid='price-and-discounted-price']");
    By expectedElementPriceApartmentField = By.xpath("//span[@data-animate-price-group-name='bp_user_total_price']");
    By chooseApartmentFiled = By.xpath("//select[@data-is-fflex-selected='0' > option[value='1']");
    //By chooseApartmentFiled1 = By.xpath("//select[@data-is-fflex-selected='0'] option[value='1']");
    //By chooseApartmentFiled = By.cssSelector("select[name='nr_rooms_35233501_343776259_2_33_0']");
    //By chooseApartmentFiled = By.xpath("//div[@class='hprt-block']/label[@for='hprt_nos_select_35233501_343776259_2_33_0']");
    //By chooseApartmentFiled = By.id("hprt_nos_select_35233501_343776259_2_33_0");
    //By confirmReservationButton = By.xpath("//button[@type='submit'][1]");
    By confirmReservationButton = By.xpath(("//span[@class='bui-button__text js-reservation-button__text']"));
    By finishingReservationButton = By.xpath(("//span[text()=' Sledeće: završni podaci ']"));
    By firstNameFiled = By.id("firstname");
    By lastNameFiled = By.id("lastname");
    By emailFiled = By.id("email");
    By emailConfirmationField = By.id("email_confirm");
    By cookiePopupFiled = By.xpath("//body[@id='b2bookPage']");

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String emailAddress = faker.internet().emailAddress();
    public String confirmationEmailAddress = faker.internet().emailAddress();





    public BookingPage(WebDriver driver) {

        super(driver);
    }

    public BookingPage goToBookingPage(){
    //clickOnElement(destinationField);
    typeIn(destinationField, "Kopaonik");
    clickOnElement(kopFiled);
    //clickOnElement(calendarFiled);
    clickOnElement(checkInDateFiled);
    clickOnElement(checkOutDateFiled);
    clickOnElement(searchButtonFiled);
    return this;
    }

    public BookingPage reservationPage() {
        //goToBookingPage();
        clickOnElement(breakfastIncludedCheckField);
        getAndClickOnRandomElement(actualPriceApartmentField);
        clickOnElement(actualPriceApartmentField);
//        return this;
//    }
//   public BookingPage randomApartmentPage(){
    //clickOnElement(chooseApartmentFiled);
    //getAndClickOnRandomElement(chooseApartmentFiled1)
    //getAndClickOnListElement(chooseApartmentFiled);
    clickOnElement(chooseApartmentFiled);
    clickOnElement(confirmReservationButton);
            return this;
    }

    public BookingPage reservationFinishingPage(String firstName, String lastName, String emailAddress, String confirmationEmailAddress){
        typeIn(firstNameFiled, firstName);
        typeIn(lastNameFiled, lastName);
        typeIn(emailFiled,emailAddress);
        typeIn(emailConfirmationField, confirmationEmailAddress);
        clickOnElement(finishingReservationButton);
        clickOnElement(cookiePopupFiled);
    return this;

    }

    public double actualPriceFiled() {
//        Random random = new Random();
//        List<WebElement> list = driver.findElements("//div[@data-testid='price-and-discounted-price']");
//        int randomElement = random.nextInt(list.size());
//        String randomPriceString = list.get(randomElement).getText();
//        String numberOnly = randomPriceString.replaceAll("[^0-9]", "");
//        double actualPrice = Integer.parseInt(numberOnly);
       return getAmountByRegex(getTextFromElement(actualPriceApartmentField));

    }
    public double expectedPriceFiled(){
//        String expectedPriceString = getElement(expectedElementPriceApartmentField).getText();
//        String numberOnlyExpectedPrice = expectedPriceString.replaceAll("[^0-9]", "");
//        double expectedPrice = Integer.parseInt(numberOnlyExpectedPrice);
       return getAmountByRegex(getTextFromElement(expectedElementPriceApartmentField));

}

}