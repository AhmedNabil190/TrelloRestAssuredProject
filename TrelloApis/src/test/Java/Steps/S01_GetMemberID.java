package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class S01_GetMemberID {


    //static String mid;

     RequestSpecification requestSpecification;

     Response response;

    @Given("Set Request")
    public void SetReq() {

        RestAssured.baseURI = Hooks.URL;
        RestAssured.basePath = "/1/members/me";
    }

    @When("put request specification")
    public  void GetReq() {
        requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key", Hooks.TrelloKey);
        requestSpecification.queryParam("token", Hooks.TrelloToken);

        response = requestSpecification.get();
        response.prettyPrint();
    }

    @Then("Check response")
    public void CheckReq() {

        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
