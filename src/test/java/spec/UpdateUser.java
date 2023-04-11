package spec;

import io.restassured.specification.ResponseSpecification;

public class UpdateUser extends BaseSpec {
    public static ResponseSpecification updateUserResponseSpec() {
        return userResponseSpec(200);
    }
}
