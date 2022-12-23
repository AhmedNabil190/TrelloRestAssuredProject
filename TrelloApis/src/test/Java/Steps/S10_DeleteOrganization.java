package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S10_DeleteOrganization {

    RequestSpecification requestSpecification;
    Response response;


    @Given("set Request for Delete Workspace")
    public void SetReq() {

        RestAssured.baseURI = Hooks.URL;
        RestAssured.basePath = String.format("/1/organizations/%s", Hooks.OrganizationID);

    }

    @When("put specification for Delete Workspace")
    public void SendGetReq() {

        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        response = requestSpecification.delete();
        response.prettyPrint();
    }

    @Then("Check response for Delete Workspace")
    public void CheckResponse() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
