package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.Auth;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen {
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement logBut;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement regBut;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public AuthenticationScreen fillEmail(String mail) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, mail);
        return this;
    }

    public AuthenticationScreen fillPassword(String pass) {
        waitElement(editTextPassword, 5);
        type(editTextPassword, pass);
        return this;
    }

    public ContactListScreen submitLogin() {
        logBut.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistration() {
        regBut.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen login(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        submitLogin();
        return new ContactListScreen(driver);
    }

    public ContactListScreen registration(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        submitRegistration();
        return new ContactListScreen(driver);
    }

    public ErrorScreen registrationTwo(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        submitRegistration();
        return new ErrorScreen(driver);
    }
    public boolean isAuthenticationScreen(){
        return shouldHave(activityViewText,"Authentication",5);
    }

}
