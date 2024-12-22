package ge.automation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;

public class MyStepdefs {

    private Response response;
    private  String path;

    @Given("Base URI is {string}")
    public void baseURIIs(String baseUri) {
        System.out.println("Base URI is: " + baseUri);
        RestAssured.baseURI = baseUri;
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = RestAssured
                .given()
                .log()
                .all()
                .get(endpoint);
    }

    @Then("the response should contains exactly {int} posts")//
    public void theResponseShouldContainsExactlyPosts(int expectedCount) {
        List<Integer> actualValues = response.jsonPath().getList("$");
        Assert.assertEquals(actualValues.size(), expectedCount, "Post count mismatch");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code mismatch");
    }


    @Then("response should contain posts with {string} equals to {int}")
    public void responseShouldContainsPostsWithEqualsToUserId(String field, int expectedValue) {
        List<Integer> actualValues = response.jsonPath().getList(field);
            boolean found = false;
            for(Integer actualValue : actualValues) {
                if (actualValue == expectedValue){
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found, "Value not found in response");
    }
}
