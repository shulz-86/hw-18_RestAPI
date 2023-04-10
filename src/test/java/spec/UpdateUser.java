package spec;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UpdateUser extends BaseSpec {

    public static RequestSpecification updateUserRequestSpec() {
        return userRequestSpec("https://reqres.in", "/api");
    }
    public static ResponseSpecification updateUserResponseSpec() {
        return userResponseSpec(200);
    }
}
