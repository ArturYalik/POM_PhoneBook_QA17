package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.User;
import org.openqa.selenium.support.FindBy;

import javax.jws.soap.SOAPBinding;

public class AddNewContactScreen extends BaseScreen {
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addBut;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createBut;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement name;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement lastName;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement mail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement phone;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement adress;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement descrip;

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addContact(User data){
        pause(5000);
        addBut.click();
        pause(5000);
        name.click();
        hideKey();
        name.sendKeys(data.getName());
        lastName.click();
        hideKey();
        lastName.sendKeys(data.getLastname());
        mail.click();
        hideKey();
        mail.sendKeys(data.getEmail());
        phone.click();
        hideKey();
        phone.sendKeys(data.getPhone());
        adress.click();
        hideKey();
        adress.sendKeys(data.getAdress());
        descrip.click();
        hideKey();
        descrip.sendKeys(data.getNote());
        createBut.click();
    }
}
