package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver; // uzliku protected jo citadi citas klases netika tam klat

    AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);

    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public  String getPageTitle () {
        return driver.getTitle();

    }

}
