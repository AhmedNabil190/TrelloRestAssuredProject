package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S07_GetLists {

    RequestSpecification requestSpecification;
    Response response;


    @Given("Set Request for get Lists")
    public void SetReq() {

        RestAssured.baseURI = Hooks.URL;
        RestAssured.basePath = String.format("/1/boards/%s/lists", Hooks.BoardID);

    }

    @When("put request specification for get Lists")
    public void SendGetReq() {

        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        response = requestSpecification.get();
        response.prettyPrint();
    }

    @Then("Check response for get Lists")
    public void CheckResponse() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
