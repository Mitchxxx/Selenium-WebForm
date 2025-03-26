package stepdefinitions;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class APITestsSteps {
    private String endpoint;
    private Response response;

    private final RestAssuredClient restAssuredClient;

    public APITestsSteps () {
        restAssuredClient = new RestAssuredClient();
    }

    @Given("the endpoint is set to {string}")
    public void theEndpointIsSetTo(String endpoint) {
        String url = ConfigReader.getProperty("apiBaseUrl");
        this.endpoint = url+ endpoint;
    }

    @When("I send a GET request")
    public void iSendAGETRequest() {
        response = restAssuredClient.get(endpoint);

    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals("unexpected status code.", expectedStatusCode, response.statusCode());
    }

    @And("the response should contain at least {int} result")
    public void theResponseShouldContainAtLeastResult(int minimumResults) {
        int count = response.jsonPath().getList("results").size();
        assertTrue("Expected at least " + minimumResults + " episodes, but found " + count, count >= minimumResults);
    }

    @And("the response should include {string} as a character in the list")
    public void theCharacterIsIncludedInTheList(String characterName) {
        List<Map<String, Object>> results = response.jsonPath().getList("results");
        boolean isNameFound = results.stream().anyMatch(result -> characterName.equals(result.get("name")));
        assertTrue("Expected name not found.", isNameFound);
    }
}
