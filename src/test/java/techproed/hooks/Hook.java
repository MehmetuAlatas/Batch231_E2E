package techproed.hooks;


import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import techproed.utilities.Authentication;


public class Hook {

    public static RequestSpecification spec;

    @Before("@api")
    public void setUp() throws Exception {
        spec =  new RequestSpecBuilder()
                .setBaseUri("https://medunna.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+ Authentication.generateToken())
                .build();
    }

}
