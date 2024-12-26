package by.yvesRocher.api.utils;

import by.yvesRocher.api.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResponseUtil {
    public static Response createResponse(User user) {
        return given()
                .body(user)
                .when()
                .post()
                .then()
                .extract().response();
    }
}
