import config.AppiumConfig;
import model.ContactData;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.LoginRegistrationScreen;
import screens.SplashSreen;

public class LaunchTeast extends AppiumConfig {

    @Test
    public void launch(){
        String version = new SplashSreen(driver).getCurrentVersion();
        System.out.println(version);
        Assert.assertTrue((version.contains("1.0.0")));
    }
    @Test
    public void login(){
        new LoginRegistrationScreen(driver).setLogFormLogin("abc@mail.com","$Sens1234");
    }
    @Test
    public void registration(){
        new LoginRegistrationScreen(driver).setLogFormRegistration("abm@mail.com","$Sens1234");
    }
    @Test(dataProvider = "regData",dataProviderClass = ContactData.class)
    public void addContact(User data){
        login();
        new AddNewContactScreen(driver).addContact(data);
    }
}
