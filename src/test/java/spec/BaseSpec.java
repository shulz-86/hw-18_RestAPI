package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class BaseSpec {
    public static RequestSpecification userRequestSpec (String baseUri, String basePath) {
         return with()
                .log().uri()
                .log().headers()
                .log().body()
                .filter(withCustomTemplates())
                .contentType(JSON)
                .baseUri(baseUri)
                .basePath(basePath);
    }

    public static ResponseSpecification userResponseSpec (int expectStatusCode) {
         return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectStatusCode)
                .build();
    }
}
