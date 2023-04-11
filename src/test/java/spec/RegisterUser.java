package spec;

import io.restassured.specification.ResponseSpecification;


public class RegisterUser  extends BaseSpec {
    public static ResponseSpecification registerUserResponseSpec() {
        return userResponseSpec(400);
    }
}
