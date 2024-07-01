package techproed.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){

        //set the payload
        String payload="{\n" +
                "  \"password\": \"Techpro123.\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"techproed\"\n" +
                "}";

        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post("https://medunna.com/api/authenticate");

       return response.jsonPath().getString("id_token");
    }




}
