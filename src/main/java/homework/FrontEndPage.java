package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrontEndPage extends AbstractPage {


    FrontEndPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public FlightPage clickFlightLink() {

        WebElement link = driver.findElement(By.cssSelector("a[href*='#TRAVELPAYOUTS']"));
        link.click();
        return new FlightPage(driver);
    }

    public HotelPage clickHotelLink() {
        WebElement link = driver.findElement(By.cssSelector("a[href*=properties]"));
        link.click();
        return new HotelPage(driver);
    }

    public TourPage clickTourLink() {
        WebElement link = driver.findElement(By.cssSelector("a[href*=tour]"));
        link.click();
        return new TourPage(driver);
    }




}
