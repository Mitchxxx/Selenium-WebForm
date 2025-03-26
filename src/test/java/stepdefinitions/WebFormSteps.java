package stepdefinitions;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.WebFormPage;
import com.automation.utils.ConfigReader;

public class WebFormSteps {
    // Use DriverManager to get the WebDriver instance
    WebDriver driver = DriverManager.getDriver();
    // Use WebFormPage to get web Elements
    WebFormPage webFormPage = new WebFormPage();

    @Given("User navigates to Selenium Web form")
    public void userNavigatesToSeleniumWebForm() {
        String url = ConfigReader.getProperty("baseUrl") + "/web-form.html";
        driver.get(url);
        System.out.println("Title of the page is: " + driver.getTitle());

    }

    @When("user inputs {string} to Text input")
    public void userFillTextInput(String input) {
        webFormPage.inputText(input);
    }

    @And("user inputs password {string}")
    public void userInputsPassword(String input) {
        webFormPage.inputPassword(input);
    }

    @And("user adds {string} to Textarea")
    public void userAddsCommentToTextarea(String comment) {
        webFormPage.inputTextArea(comment);
    }

    @Then("user clicks the submit button")
    public void userClicksTheSubmitButton() {
        webFormPage.submit();
    }

    @And("user selects {string} from select menu")
    public void userSelects(String option) {
      webFormPage.selectDropDownByText(option);
    }

    @And("user select {string} city")
    public void userSelectCity(String city) {
        webFormPage.selectFromDataList(city);
    }

    @And("user verifies {string} is visible")
    public void userVerifiesIsVisible(String arg0) {
        webFormPage.assertReadOnly(arg0);
    }

    @And("user selects checkbox {string}")
    public void userSelectsCheckbox(String option) {
        webFormPage.checkBox(option);
    }

    @And("user clicks {string} radio button")
    public void userClicksRadioButton(String option) {
        webFormPage.radioButton(option);
    }

    @And("user chooses {string} as date")
    public void userChooses(String date) {
        webFormPage.datePicker(date);
    }

    @And("user verifies form is submitted")
    public void userVerifiesFormIsSubmitted() {
        webFormPage.assertPageTitle("Form submitted");
        webFormPage.assertMessage("Received!");
    }

    @And("user moves slider to {string}")
    public void userMovesSliderTo(String arg0) {
        webFormPage.moveSlider(arg0);
    }
}