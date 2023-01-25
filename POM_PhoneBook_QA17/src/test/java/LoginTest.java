import config.AppiumConfig;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashSreen;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginSuccess(){
       boolean res = new SplashSreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abc@mail.com")
                .fillPassword("$Sens1234")
                .submitLogin()
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }

    @Test
    public void loginSuccessModel() {
        boolean res = new SplashSreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder().email("abcmail.com").password("$Sens1234").build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }
    @AfterMethod
    public void postCondition(){
       if(new ContactListScreen(driver).isContactListActivityPresent()){
           new ContactListScreen(driver).logout();
           new SplashSreen(driver);
       }
    }
}
