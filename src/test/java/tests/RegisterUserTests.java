package tests;

import models.lombok.UserRegisterBody;
import models.lombok.UserRegisterResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.BaseSpec;
import spec.RegisterUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RegisterUserTests extends BaseSpec {

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
}
