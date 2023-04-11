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
public class ReqresInTests extends BaseSpec {
    @DisplayName("Проверка данных одного конкретного пользвателя")
    @Test
    void checkSingleUserInfo() {
        SingleUsersResponseContainer response = step("Проверка данных одного пользвателя", () ->
            given(userRequestSpec())
                    .when()
                    .get("/users/2")
                    .then()
                    .spec(SingleUser.singleUserResponseSpec())
                    .extract().as(SingleUsersResponseContainer.class));

        step("Проверка данных одного пользвателя", () -> {
            assertThat(response.getData()).isNotNull();
            assertThat(response.getData().getId()).isEqualTo(2);
            assertThat(response.getData().getFirstName()).isEqualTo("Janet");
            assertThat(response.getData().getLastName()).isEqualTo("Weaver");
        });
    }
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

    @DisplayName("Проверка негативного кейса регистрации")
    @Test
    void checkUserRegisterNegative() {
        UserRegisterBody registerBody = new UserRegisterBody();
        registerBody.setEmail("sydney@fife");

        UserRegisterResponse response = step("Ввод данных", () ->
                given(userRequestSpec())
                        .body(registerBody)
                        .when()
                        .post("/register")
                        .then()
                        .spec(RegisterUser.registerUserResponseSpec())
                        .extract().as(UserRegisterResponse.class));

        step("Проверка негативного кейса регистрации", () -> {
            assertThat(response.getError()).isEqualTo("Missing email or username");
        });
    }

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

    @DisplayName("Проверка удаления пользвателя")
    @Test
    void checkDeleteUser() {
        step("Проверка удаления пользвателя", () -> {
            given(userRequestSpec())
                    .when()
                    .delete("users/2")
                    .then()
                    .statusCode(204);
        });
    }
}
