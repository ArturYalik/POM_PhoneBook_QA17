import config.AppiumConfig;
import model.ContactData;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.AuthenticationScreen;
import screens.SplashSreen;

public class LaunchTeast extends AppiumConfig {

    @Test
    public void launch(){
        String version = new SplashSreen(driver).getCurrentVersion();
        System.out.println(version);
        Assert.assertTrue((version.contains("1.0.0")));
    }
//    @Test
//    public void login(){
//        new AuthenticationScreen(driver).fillEmail("abc@mail.com");
//        new AuthenticationScreen(driver).fillPassword("$Sens1234");
//    }
//    @Test
//    public void registration(){
//        new AuthenticationScreen(driver).fillEmail("avc@mail.com");
//        new AuthenticationScreen(driver).fillPassword("$Sens1234");
//    }
//    @Test(dataProvider = "regData",dataProviderClass = ContactData.class)
//    public void addContact(User data){
//        login();
//        new AddNewContactScreen(driver).addContact(data);
//    }
}
