package spec;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SingleUser  extends BaseSpec {
    public static RequestSpecification singleUserRequestSpec() {
        return userRequestSpec("https://reqres.in", "/api");
    }
    public static ResponseSpecification singleUserResponseSpec() {
        return userResponseSpec(200);
    }
}
