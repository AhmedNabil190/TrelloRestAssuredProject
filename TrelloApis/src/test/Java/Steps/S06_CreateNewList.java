package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S06_CreateNewList {

    RequestSpecification requestSpecification;
    Response response;
    JsonPath jsonPath;


    @Given("set Request for craete List")
    public void SetReq() {
        RestAssured.baseURI = Hooks.URL  ;
        RestAssured.basePath = "/1/lists";
    }

    @When("put specification for create List")
    public void PostReq()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        requestSpecification.queryParam("idBoard",Hooks.BoardID);
        requestSpecification.queryParam("name", "FirstListCreated");
        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.post();
        response.prettyPrint();
    }


    @Then("Check response for create List")
    public void CheckResponse() {

        jsonPath =response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getString("name"), "FirstListCreated");
    }

}
