package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    protected FrontEndPage frontEndPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {

        //Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandra/git/Tools/chromedriver");
        driver = new ChromeDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Set timeouts
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Thread.sleep(5000);
        //driver.quit();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown (){
        //Close browser
        driver.quit();
    }

//    @BeforeMethod(dependsOnGroups={"admin"})
//    public void openMainPage() throws InterruptedException {
//        //Open page
//        //driver.get("https://www.ss.com"); replaced by below after page object patter is used
////        mainPage = new mainPage(driver);
////        mainPage.open("https://www.ss.com");
//        adminPage = new AdminPage(driver);
//        adminPage.open("http://www.phptravels.net/admin");
//    }

//    @AfterMethod(dependsOnGroups={"needLogout"})
//    public void logoutFromAdmin() throws InterruptedException {
//        //if (driver.getTitle().contains("Dashboard"))
//        adminPage.open("http://www.phptravels.net/admin/logout");
//
//    }

//    @BeforeMethod( dependsOnGroups={"FrontEnd"})
//    public void openFrontEndPage() throws InterruptedException {
//        frontEndPage = new FrontEndPage(driver);
//        frontEndPage.open("http://www.phptravels.net/");
//    }
}
