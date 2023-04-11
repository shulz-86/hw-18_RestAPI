package spec;

import io.restassured.specification.ResponseSpecification;


public class SingleUser  extends BaseSpec {
    public static ResponseSpecification singleUserResponseSpec() {
        return userResponseSpec(200);
    }
}
