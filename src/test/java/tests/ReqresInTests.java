package tests;

import io.qameta.allure.Owner;

import modal.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static spec.CreatedUser.*;
import static spec.DeleteUser.*;
import static spec.RegisterUser.*;
import static spec.SingleUser.*;
import static spec.UpdateUser.*;

@Owner("Olshanskaya")
public class ReqresInTests {
    @DisplayName("Проверка данных одного конкретного пользвателя")
    @Test
    void checkSingleUserInfo() {
        SingleUsersResponseContainer response = step("Проверка данных одного пользвателя", () ->
            given(singleUserRequestSpec)
                    .when()
                    .get("/users/2")
                    .then()
                    .spec(singleUserResponseSpec)
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
                given(createdUserRequestSpec)
                        .when()
                        .post("/users")
                        .then()
                        .spec(createdUserResponseSpec)
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
                given(registerUserRequestSpec)
                        .when()
                        .post("/register")
                        .then()
                        .spec(registerUserResponseSpec)
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
                given(updateUserRequestSpec)
                .when()
                .put("users/2")
                .then()
                .spec(updateUserResponseSpec)
                .extract().as(UserUpdateResponse.class));

        step("Проверка обновления пользователя", () -> {
            assertThat(response.getUpdatedAt()).isNotNull();
        });
    }

    @Test
    void checkDeleteUser() {
        step("Проверка удаления пользвателя", () -> {
            given(deletedUserRequestSpec)
                    .when()
                    .delete("/users/2")
                    .then()
                    .spec(deletedUserResponseSpec);
        });
    }
}
