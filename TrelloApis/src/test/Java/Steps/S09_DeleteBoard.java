package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S09_DeleteBoard {

    RequestSpecification requestSpecification;
    Response response;


    @Given("set Request for Delete Board")
    public void SetReq() {

        RestAssured.baseURI = Hooks.URL;
        RestAssured.basePath = String.format("/1/boards/%s", Hooks.BoardID);

    }

    @When("put specification for Delete Board")
    public void SendGetReq() {

        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        response = requestSpecification.delete();
        response.prettyPrint();
    }

    @Then("Check response for Delete Board")
    public void CheckResponse() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
