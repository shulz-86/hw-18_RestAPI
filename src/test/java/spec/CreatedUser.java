package spec;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class CreatedUser extends BaseSpec {
    public static RequestSpecification createdUserRequestSpec() {
        return userRequestSpec("https://reqres.in", "/api");
    }
    public static ResponseSpecification createdUserResponseSpec() {
        return userResponseSpec(201);
    }
}
