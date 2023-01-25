import config.AppiumConfig;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.ErrorScreen;
import screens.SplashSreen;

public class RegistrationTestNegative extends AppiumConfig {

    @Test
    public void registrationNotSuccsess() {
        boolean res = new SplashSreen(driver).gotoAuthenticationScreen()
                .registrationTwo(Auth.builder().email("vbcmail.com").password("$Sens1234").build())
                .isErrorScreen();
        Assert.assertTrue(res);
            new ErrorScreen(driver).pause(5);
            new ErrorScreen(driver).returnAauthenticationScreen();
    }

    @Test
    public void registrationNotSuccsessTwo() {
        new SplashSreen(driver).gotoAuthenticationScreen()
                .registration(Auth.builder().email("vbcmail.com").password("$Sens1234").build())
                .isAlert().accept();
    }

        @AfterMethod
    public void postCondition(){
        if(new  AuthenticationScreen(driver).isAuthenticationScreen())
            System.out.println("True");
        else
            System.out.println("False");
    }

}
