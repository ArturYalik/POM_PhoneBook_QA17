import config.AppiumConfig;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashSreen;

public class RegistrationTestPositive extends AppiumConfig {

    @Test
    public void registrationSuccsess(){
        boolean res = new SplashSreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("avc@mail.com")
                .fillPassword("$Sens1234")
                .submitRegistration()
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }

    @Test
    public void registrationSuccsessModel(){
        boolean res = new SplashSreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder().email("vbc@mail.com").password("$Sens1234").build())
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
