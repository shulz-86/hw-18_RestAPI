package tests;

import models.lombok.CreatedUserIdResponse;
import models.lombok.UserBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;
import spec.CreatedUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreatedUserTests extends BaseSpec {
    @DisplayName("Проверка Id при создании пользователя")
    @Test
    void checkCreatedUserIdIsNotNull() {
        UserBody data = new UserBody();
        data.setName("morpheus");
        data.setJob("leader");

        CreatedUserIdResponse createdUserIdResponse = step("Ввод данных", () ->
                given(userRequestSpec())
                        .body(data)
                        .when()
                        .post("/users")
                        .then()
                        .spec(CreatedUser.createdUserResponseSpec())
                        .extract().as(CreatedUserIdResponse.class));

        step("Проверка Id не пустое", () -> {
            assertThat(createdUserIdResponse.getName()).isEqualTo("morpheus");
            assertThat(createdUserIdResponse.getJob()).isEqualTo("leader");
            assertThat(createdUserIdResponse.getId()).isNotNull();
        });
    }
}
