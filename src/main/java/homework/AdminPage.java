package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends AbstractPage {

    @FindBy(css = "input[type='text']")
    WebElement eMail;

    @FindBy(css = "input[type='password']")
    WebElement password;

    @FindBy(css="button[type='submit']")
    WebElement loginButton;

    @FindBy(css="div.alert")
    WebElement loginError;

    AdminPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public AdminPage enterEmail(String email){
        WebElement eMail2 = eMail;
        eMail2.clear();
        eMail2.sendKeys(email);
        return this;
    }

    public AdminPage enterPass(String pass){
        WebElement password2 = password;
        password2.clear();
        password2.sendKeys(pass);
        return this;
    }

    public AdminPage submitLogin(){
        loginButton.click();
        return this;
    }

    public boolean isErrorDisplayed() {
        return loginError.isDisplayed();
    }
}
