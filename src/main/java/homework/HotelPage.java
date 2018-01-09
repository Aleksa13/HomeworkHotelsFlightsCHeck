package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends AbstractPage {

//    @FindBy(css ="btn btn-warning btn-xs btn-block")
//    WebElement filterButton;

    @FindBy(css ="#body-section > div.header-mob.mt-25 > div > div > div:nth-child(4) > div > a")
    WebElement filterButton;

    @FindBy(id ="searchform")
    WebElement searchButton;

    @FindBy(css ="tr:nth-child(1) h4 > a")
    WebElement chooseHotelButton;

    @FindBy(css="#ROOMS > form:nth-child(2) span")
    WebElement bookHotelButton;

    @FindBy(css="div.modal.fade.in")
    WebElement bookingAlert;

    HotelPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public WebElement filterButton(){
        return filterButton;
    }

    public HotelPage selectFilterElementById(String ID){
        WebElement selectedElement = driver.findElement(By.id("#"+ID));
        selectedElement.click();
        return this;
    }

    public WebElement searchButton (){return searchButton;}

    public WebElement bookingAlert (){return bookingAlert;}

    public WebElement chooseHotelButton (){return chooseHotelButton;}

    public WebElement bookHotelButton (){return bookHotelButton;}
}
