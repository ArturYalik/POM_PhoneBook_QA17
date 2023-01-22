package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationScreen extends BaseScreen {
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement email;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement password;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement logBut;
    @FindBy(xpath = "//*[@resource-id='@com.sheygam.contactapp:id/regBtn']")
    MobileElement regBut;
//    @FindBy(xpath = "//*[@resource-id='@com.sheygam.contactapp:id/regBtn']")
//    MobileElement contactList;



    public LoginRegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void setLogFormLogin(String mail,String pass) {
        pause(5000);
        email.click();
        email.sendKeys(mail);
        password.click();
        password.sendKeys(pass);
        logBut.click();
    }

    public void setLogFormRegistration(String mail,String pass) {
        pause(5000);
        email.click();
        email.sendKeys(mail);
        password.click();
        password.sendKeys(pass);
        regBut.click();
    }
}
