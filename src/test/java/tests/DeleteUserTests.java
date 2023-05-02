package tests;

import models.lombok.SingleUsersResponseContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;
import spec.SingleUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteUserTests extends BaseSpec {
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
