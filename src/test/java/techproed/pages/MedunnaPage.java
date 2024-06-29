package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MedunnaPage {

    /*
     PageFactory.initElements(Driver.getDriver(),this); kodu bu classtaki ögeleri
     webdriver ile eslestirir, bu sayede classtaki webelemenetlere erismek icin @FindBy
     gibi PageFactory ye yardimci notasyonlar kullanilablir hale gelir
     */
    public MedunnaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "account-menu")
    public WebElement userIcon;
    @FindBy(id = "login-item")
    public WebElement signInOption;
    @FindBy(id = "username")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;

    //buraya kadar medunna sign in page seklinde ayri
    // class olusturmak daha güzel olur


    @FindBy(id = "entity-menu")
    public WebElement itemsdAndTitles;

    @FindBy( xpath = "//span[.='Room']")
    public WebElement roomOption;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewRoomButton;

    @FindBy(id = "room-roomNumber")
    public WebElement roomNumberInput;

    @FindBy(id = "room-roomType")
    public WebElement roomTypeDropDown;

    @FindBy(id = "room-status")
    public WebElement statusCheckBox;

    @FindBy(id = "room-price")
    public WebElement priceInput;
    @FindBy(id = "room-description")
    public WebElement descriptionInput;

    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;


    //*[contains(text(),'A new Room')]
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;








}
