package spec;

import io.restassured.specification.ResponseSpecification;


public class CreatedUser extends BaseSpec {
    public static ResponseSpecification createdUserResponseSpec() {
        return userResponseSpec(201);
    }
}
