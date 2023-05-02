package tests;

import models.lombok.SingleUsersResponseContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;
import spec.SingleUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class SingleUserTests extends BaseSpec {
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
}
