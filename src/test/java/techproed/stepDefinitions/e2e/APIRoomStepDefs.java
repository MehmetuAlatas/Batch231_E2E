package techproed.stepDefinitions.e2e;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import techproed.pojos.RoomPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static techproed.hooks.Hook.spec;

public class APIRoomStepDefs {

    Response response;
    RoomPojo expectedData;

    @Given("A Get request is sent")
    public void aGetRequestIsSent() {

        //set the url  ==>  https://medunna.com/api/rooms/119136
        spec.pathParams("first","api","second","rooms","third",DBRoomStepDefs.roomId);

        //set the expected data
        expectedData = new RoomPojo(UIMedunnaStepdefs.roomNumber,"SUITE",true,123.00,UIMedunnaStepdefs.expectedDescription);

        //send request get response
        response = given(spec).when().get("{first}/{second}/{third}");


    }

    @Then("Response is validated")
    public void responseIsValidated() {
        //do assertion
        RoomPojo actualData = response.as(RoomPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.isStatus(),actualData.isStatus());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDescription(),actualData.getDescription());

    }
}
