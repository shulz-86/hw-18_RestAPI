package spec;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RegisterUser  extends BaseSpec {
    public static RequestSpecification registerUserRequestSpec() {
        return userRequestSpec("https://reqres.in", "/api");
    }
    public static ResponseSpecification registerUserResponseSpec() {
        return userResponseSpec(400);
    }
}
