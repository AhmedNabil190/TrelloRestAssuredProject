package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S04_CreateNewBoard {


    RequestSpecification requestSpecification;
    Response response;
    JsonPath jsonPath;


    @Given("set Request for craete Board")
    public void SetReq() {
        RestAssured.baseURI = Hooks.URL  ;
        RestAssured.basePath = "/1/boards/";
    }

    @When("put specification for create Board")
    public void PostReq()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);
        requestSpecification.queryParam("idOrganization",Hooks.OrganizationID);
        requestSpecification.queryParam("name", "FirstBoardCreated");
        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.post();
        response.prettyPrint();
    }


    @Then("Check response for create Board")
    public void CheckResponse() {

        jsonPath =response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonPath.getString("name"), "FirstBoardCreated");
    }

}
