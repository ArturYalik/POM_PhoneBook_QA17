package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ErrorScreen extends BaseScreen{
    public ErrorScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "android:id/alertTitle")
    MobileElement erroeScreen;
    @FindBy(id = "android:id/button1")
    MobileElement okBut;

    public boolean isErrorScreen() {
        return isElementPresent(erroeScreen);
    }
    public AuthenticationScreen returnAauthenticationScreen(){
        okBut.click();
        return new AuthenticationScreen(driver);
    }



}
