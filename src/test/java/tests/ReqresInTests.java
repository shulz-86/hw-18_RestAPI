package tests;

import io.qameta.allure.Owner;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

@Owner("Olshanskaya")
public class ReqresInTests {
    @Test
    void checkSingleUserInfo() {
        get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }

    @Test
    void checkCreatedUserIdIsNotNull() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .body(data)
                .when()
                .log().body()
                .post("https://reqres.in/api/users")
                .then()
                .log().body()
                .log().status()
                .statusCode(201)
                .body("id", notNullValue());
    }

    @Test
    void checkDelayedResponse() {
        given()
                .param("delay", 3)
                .when()
                .log().uri()
                .get("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(200)
                .body("data[0].id", is(1))
                .body("data[0]", hasEntry("email", "george.bluth@reqres.in"));
    }

    @Test
    void checkUserRegisterNegative() {
        String data = "{\"password\": \"pistol\" }";

        given()
                .body(data)
                .when()
                .log().uri()
                .log().body()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(400);
    }

    @Test
    void checkUserUpdate() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        given()
                .contentType(JSON)
                .body(data)
                .when()
                .log().body()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("updatedAt", notNullValue());
    }

    @Test
    void checkDeleteUser() {
        delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }
}
