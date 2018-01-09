package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomeworkTest extends BaseTest {

    protected FrontEndPage frontEndPage;




    @Test(dataProvider = "bookFlight", dataProviderClass = TestDataProvider.class, groups = {"FrontEnd"})
    public void bookFlight(String destination, String departDay, String returnDay) throws InterruptedException {
            frontEndPage = new FrontEndPage(driver);
            frontEndPage.open("http://www.phptravels.net/");
            FlightPage flightPage1 = frontEndPage.clickFlightLink();
        Thread.sleep(2000);

        //driver.switchTo().frame(driver.findElement(By.id("tpcwl_iframe")));
            flightPage1.getflightDestination("Athenes,Greece");

            flightPage1
                    .flightDepart(departDay)
                    .flightReturn(returnDay)
                    .search();
        Thread.sleep(3000);

        //flightPage1.bookFlightButton().click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(flightPage1.getPageTitle(),"Flights","flights page open failed")
        ;

            //assertFalse(driver.getCurrentUrl().contains("phptravels"));
    }




    @Test(dataProvider = "bookHotel", dataProviderClass = TestDataProvider.class,groups = {"FrontEnd"})
    public void bookHotel(String hotelStars) throws InterruptedException {
        frontEndPage = new FrontEndPage(driver);
        frontEndPage.open("http://www.phptravels.net/");
        HotelPage hotelpage1 = frontEndPage.clickHotelLink();
        hotelpage1.filterButton().click();
        WebDriverWait block = new WebDriverWait(driver,10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar_filter > div > div")));
        WebElement pan = modal.findElement(By.cssSelector(hotelStars));
        pan.click();
        hotelpage1.searchButton().click();
        hotelpage1.chooseHotelButton().click();
        hotelpage1.bookHotelButton().click();
        Thread.sleep(1000);
        assertTrue(hotelpage1.bookingAlert().isDisplayed(), "hotel is not booked");



    }

    @Test(dataProvider = "bookJourney", dataProviderClass = TestDataProvider.class,groups = {"FrontEnd"})
    public void bookJourney(String journeyType) throws InterruptedException {
        frontEndPage = new FrontEndPage(driver);
        frontEndPage.open("http://www.phptravels.net/");
        TourPage tourPage1 = frontEndPage.clickTourLink();
        tourPage1.filterButton().click();
        //tourPage1.selectFilterElementById(journeyType);
        WebDriverWait block = new WebDriverWait(driver,10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar_filter > div > div")));
        WebElement pan = modal.findElement(By.cssSelector(journeyType));
        pan.click();
        tourPage1.searchButton().click();
        tourPage1.chooseTourButton().click();
        tourPage1.bookTourButton().click();
        assertTrue(driver.getCurrentUrl().contains("book"), "Not booked");


    }

}
