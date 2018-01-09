package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TourPage extends AbstractPage {


    @FindBy(css ="#body-section > div.header-mob.mt-25 > div > div > div:nth-child(4) > div > a")
    WebElement filterButton;

    @FindBy(id ="searchform")
    WebElement searchButton;

    @FindBy(css="tr:nth-child(1) h4 > a")
    WebElement chooseTourButton;

    @FindBy(css="form > div:nth-child(5) > button")
    WebElement bookTourButton;

    TourPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public WebElement filterButton(){
        return filterButton;
    }

    public TourPage selectFilterElementById(String ID){
        WebElement selectedElement = driver.findElement(By.id("#"+ID));
        selectedElement.click();
        return new TourPage(driver);
    }

    public WebElement searchButton (){return searchButton;}

    public WebElement chooseTourButton (){return chooseTourButton;}

    public WebElement bookTourButton (){return bookTourButton;}
}
