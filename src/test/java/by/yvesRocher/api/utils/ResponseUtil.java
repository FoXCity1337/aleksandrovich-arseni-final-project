package by.yvesRocher.api.utils;

import by.yvesRocher.api.Registration;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResponseUtil {
    public static Response createResponse(Registration user) {
        return given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().response();
    }
}
