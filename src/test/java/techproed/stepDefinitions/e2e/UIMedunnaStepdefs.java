package techproed.stepDefinitions.e2e;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import techproed.pages.MedunnaPage;
import techproed.utilities.*;

public class UIMedunnaStepdefs {

    public static int roomNumber;
    public static String expectedDescription;
    public static String expectedPrice;
    MedunnaPage medunnaPage = new MedunnaPage();

    @Given("the user navigates to the {string} website")
    public void theUserNavigatesToTheWebsite(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
    }

    @When("the user clicks on the user icon")
    public void theUserClicksOnTheUserIcon() {
        medunnaPage.userIcon.click();
    }

    @And("clicks on the sign in option")
    public void clicksOnTheSignInOption() {
        medunnaPage.signInOption.click();
    }

    @And("enters the username in the username field")
    public void entersTheUsernameInTheUsernameField() {
        medunnaPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @And("enters the password in the password field")
    public void entersThePasswordInThePasswordField() {
        medunnaPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @And("clicks on the sign in button")
    public void clicksOnTheSignInButton() {
        medunnaPage.signInSubmitButton.click();
    }

    @And("clicks on the Items and Titles option")
    public void clicksOnTheItemsAndTitlesOption() {
        medunnaPage.itemsdAndTitles.click();
    }

    @And("clicks on the room option")
    public void clicksOnTheRoomOption() {
        medunnaPage.roomOption.click();
    }

    @And("click on the Create a new room button")
    public void clickOnTheCreateANewRoomButton() {
        medunnaPage.createANewRoomButton.click();
    }

    @And("enters a room number in the room number field")
    public void entersARoomNumberInTheRoomNumberField() {
        roomNumber = Faker.instance().number().numberBetween(100000, 1000000);
        medunnaPage.roomNumberInput.sendKeys(roomNumber + "");
    }

    @And("selects SUITE from the room type menu")
    public void selectsSUITEFromTheRoomTypeMenu() {
        BrowserUtils.dropdownSelectByVisibleText(medunnaPage.roomTypeDropDown, "SUITE");
    }


    @And("clicks on the status checkbox")
    public void clicksOnTheStatusCheckbox() {
        medunnaPage.statusCheckBox.click();
    }

    @And("enters {string} in the Price field")
    public void entersInThePriceField(String price) {
        medunnaPage.priceInput.sendKeys(price);
        expectedPrice =price;

    }

    @And("enters a {string} in the Description field")
    public void entersAInTheDescriptionField(String description) {
        medunnaPage.descriptionInput.sendKeys(description);
        expectedDescription=description;
    }

    @And("clicks on the save button")
    public void clicksOnTheSaveButton() {
        ReusableMethods.click(medunnaPage.saveSubmitButton);
    }

    @Then("verify A new Room is created succesfully")
    public void verifyANewRoomIsCreatedSuccesfully() {
        WaitUtils.waitForVisibility(medunnaPage.alert, 5);
        Assert.assertTrue(medunnaPage.alert.isDisplayed());
    }

    @And("closes the application")
    public void closesTheApplication() {
        Driver.closeDriver();
    }
}
