package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S08_ArchiveOrUnarchiveList {
    RequestSpecification requestSpecification;
    Response response;
    JsonPath jsonPath;


    @Given("set Request for Archive List")
    public void SetReq() {
        RestAssured.baseURI = Hooks.URL;
        RestAssured.basePath = String.format("/1/lists/%s/closed", Hooks.ListID);
    }

    @When("put specification for Archive List")
    public void PostReq() {
        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        requestSpecification.queryParam("value", "true");
        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.put();
        response.prettyPrint();
    }


    @Then("Check response for Archive List")
    public void CheckResponse() {

        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
