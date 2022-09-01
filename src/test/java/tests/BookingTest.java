package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;

public class BookingTest extends BaseTest {

    BookingPage bookingPage;


    @BeforeMethod
    public void localSetup(){

        bookingPage = new BookingPage(driver);
}
    @Test
    public void BookingTest(){
    bookingPage.goToBookingPage();
    bookingPage.reservationPage();
    bookingPage.reservationFinishingPage("Jovan", "Jovanovic", "jovan@gmail.com", "jovan@gmail.com");
    softAssert.assertEquals(bookingPage.actualPriceFiled(), bookingPage.expectedPriceFiled());
    }


}