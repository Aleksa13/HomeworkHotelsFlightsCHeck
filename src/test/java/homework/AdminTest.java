package homework;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by aleksandra on 1/9/18.
 */
public class AdminTest extends BaseTest {
    protected AdminPage adminPage;


    @Test(dataProvider = "adminNegativeLogin", dataProviderClass = TestDataProvider.class)
    public void adminNegativeLogin(String email, String pass) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //openAdminPage();
        adminPage.enterEmail(email).enterPass(pass).submitLogin();
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Administator Login"),"Page title is NOT Administator Login");
        softAssert.assertTrue(adminPage.isErrorDisplayed(), "Error is no displayed");
        softAssert.assertAll();
    }

    @BeforeMethod(alwaysRun = true)
    public void openAdminPage() throws InterruptedException {
        adminPage = new AdminPage(driver);
        adminPage.open("http://www.phptravels.net/admin");

        if(!driver.getTitle().contains("Administator Login")){
            adminPage.open("http://www.phptravels.net/admin/logout");
        }

    }

    @Test(dataProvider = "adminLoginTest", dataProviderClass = TestDataProvider.class, groups={"admin","needLogout"})
    public void adminLoginTest(String email, String pass) throws InterruptedException {
        //openAdminPage();
        adminPage
                .enterEmail(email)
                .enterPass(pass)
                .submitLogin()
        ;
        Thread.sleep(2000);
        assertFalse(driver.getTitle().contains("Administator Login"),"Page title is Administator Login");

    }
}
