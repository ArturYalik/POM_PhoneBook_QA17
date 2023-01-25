package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;

public class ContactListScreen extends BaseScreen {
    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement addBut;
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOption;
    @FindBy(id = "com.sheygam.contactapp:id/title")
    MobileElement logout;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;
    @FindBy(id = "android:id/alertTitle")
    MobileElement erroeScreen;

    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isContactListActivityPresent() {
        return shouldHave(activityViewText, "Contact list", 5);
    }
    public Alert isAlert(){
        return shouldAlert(erroeScreen,"Error",5);
    }
    public AuthenticationScreen logout() {
        moreOption.click();
        logout.click();
        return new AuthenticationScreen(driver);
    }


}
