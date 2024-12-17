package by.yvesRocher.api;

import by.yvesRocher.api.utills.Specifications;
import by.yvesRocher.ui.utils.random.RandomData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserDataTest {
    public static String url = "https://api.y-r.by";

    @Test
    public void test1() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(200));
        Registration user = new Registration("theintosky@gmail.com", "zezeni8686");
        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().as(SuccessLogin.class);
        Assertions.assertNotNull(successLogin.getToken());
    }

    @Test
    public void test2() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(422));
        Registration user = new Registration(RandomData.generateEmail(), "");
        Response response = given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String password = jsonPath.get("errors.password[0]");
        Assertions.assertEquals(ResponseMessages.EMPTY_PASSWORD, password);
    }

    @Test
    public void test3() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(422));
        Registration user = new Registration("", RandomData.generatePassword(1, 5));
        Response response = given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String password = jsonPath.get("errors.password[0]");
        Assertions.assertEquals(ResponseMessages.SHORT_PASSWORD, password);
    }

    @Test
    public void test4() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(422));
        Registration user = new Registration("", RandomData.generatePassword(6, 30));
        Response response = given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String password = jsonPath.get("errors.email[0]");
        Assertions.assertEquals(ResponseMessages.EMPTY_EMAIL, password);
    }

    @Test
    public void test5() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(422));
        Registration user = new Registration("123", RandomData.generatePassword(6, 30));
        Response response = given()
                .body(user)
                .when()
                .post("/api/v1/token")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String password = jsonPath.get("errors.email[0]");
        Assertions.assertEquals(ResponseMessages.INVALID_EMAIL, password);
    }
}
