package tests;

import io.qameta.allure.Owner;

import models.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


@Owner("Olshanskaya")
public class UpdateUserTests extends BaseSpec {

    @DisplayName("Проверка обновления пользователя")
    @Test
    void checkUserUpdate() {
        UserBody data = new UserBody();
        data.setName("morpheus");
        data.setJob("zion resident");

        UserUpdateResponse response = step("", () ->
                given(userRequestSpec())
                        .body(data)
                        .when()
                        .put("users/2")
                        .then()
                        .spec(UpdateUser.updateUserResponseSpec())
                        .extract().as(UserUpdateResponse.class));

        step("Проверка обновления пользователя", () -> {
            assertThat(response.getUpdatedAt()).isNotNull();
        });
    }
}
