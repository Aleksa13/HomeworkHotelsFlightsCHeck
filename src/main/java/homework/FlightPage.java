package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage extends AbstractPage {

//    @FindBy(id ="flights-destination-prepop-whitelabel_en")
//    WebElement flightDestination;

    @FindBy (name = "destination_name")
    //@FindBy(css ="#flights-form-whitelabel_en > div.mewtwo-flights-destination > input[type='text']")
    WebElement flightDestination;

    @FindBy(id ="flights-dates-depart-prepop-whitelabel_en")
    WebElement flightDepartDay;

    @FindBy(id ="flights-dates-return-prepop-whitelabel_en")
    WebElement flightReturnDay;

    @FindBy(css ="div.mewtwo-flights-submit_button > button")
    WebElement flightSearchButton;

    @FindBy(css ="div.tickets-container > div:nth-child(9) > div:nth-child(1)  div.ticket-action-button.ticket-action-button-- > a")
    WebElement bookFlightButton;

    FlightPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }


    public FlightPage getflightDestination (String destination) throws InterruptedException {
        WebElement flightDestination2 = flightDestination;
        //System.out.println("pirms "+flightDestination2.getText());
        flightDestination2.clear();
        //System.out.println(flightDestination2.getText());
        Thread.sleep(2000);
        //System.out.println("padotais "+destination);
        flightDestination2.sendKeys(destination);

        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector("ul > li.mewtwo-autocomplete-list-item:nth-child(1)")).click() ;
        driver.switchTo().activeElement();

        System.out.println("esošais "+flightDestination2.getText());
        return this;
    }

    public FlightPage flightDepart (String depart){
//        WebElement flightDepart2 = flightDepartDay;
//        flightDepart2.clear();
//        flightDepart2.sendKeys(depart);
        WebElement departDate = driver.findElement(By.cssSelector(".mewtwo-flights-dates .mewtwo-flights-dates-depart"));
        departDate.click();


        driver.switchTo().activeElement();
        WebElement enterDate = driver.findElement(By.id("mewtwo-datepicker-" +depart));
        enterDate.click();
        driver.switchTo().activeElement();
        return this;
    }

    public FlightPage flightReturn (String returnDay){
//        WebElement flightReturn2 = flightReturnDay;
//        flightReturn2.clear();
//        flightReturn2.sendKeys(returnDay);
        WebElement departDate = driver.findElement(By.cssSelector(".mewtwo-flights-dates .mewtwo-flights-dates-return"));
        departDate.click();

        driver.switchTo().activeElement();
        WebElement returnDate = driver.findElement(By.id("mewtwo-datepicker-"+returnDay));
        returnDate.click();
        driver.switchTo().activeElement();
        return this;
    }

    public FlightPage search() {
        flightSearchButton.click();
        return this;
    }

    public WebElement bookFlightButton (){return bookFlightButton;}


}
