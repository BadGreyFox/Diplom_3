package stellarburgers.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static stellarburgers.pom.BasePage.HOME_PAGE_URL;

public class BaseApi {
    private static RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(HOME_PAGE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    protected static Response postRequest(Object json, String api){
        return given()
                .spec(getSpec())
                .and()
                .body(json)
                .when()
                .post(api);
    }

    protected static void deleteRequest(String token, String api){
        given()
                .spec(getSpec())
                .auth().oauth2(token)
                .when()
                .delete(api);
    }
}
