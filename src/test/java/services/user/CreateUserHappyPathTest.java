package services.user;

import helpers.UserHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserHappyPathTest {

    UserHelper userHelper = new UserHelper();
    Random random = new Random();
    Integer userId = random.nextInt(10);
    String username = "kudkipz";
    String firstname = "Monika";
    String lastname = "Kowalski";
    String email = "kudkipz@gmail.com";
    String password = "password1";
    Integer phone = 667745799;
    String userStatus = "unknown";

    @Test
    @DisplayName("Create user - happy path.")
    public void createUserHappyPath() {
        Response response = userHelper.createUser(userId, username, firstname, lastname, email, password, phone, userStatus);

        /*
        Assertions.assertAll(
                () -> assertEquals(200, response.getStatusCode()),
                () -> assertEquals((int) userId, response
                        .jsonPath()
                        .getInt("id")),
                () -> assertEquals(response
                        .jsonPath()
                        .getString("username"), username),
                () -> assertEquals(response
                        .jsonPath()
                        .getString("firstName"), firstname),
                () -> assertEquals(response
                        .jsonPath()
                        .getString("lastName"), lastname),
                () -> assertEquals(response
                        .jsonPath()
                        .getString("email"), email),
                () -> assertEquals((int) phone, response
                        .jsonPath()
                        .getInt("phone")),
                () -> assertEquals(response
                        .jsonPath()
                        .getString("userStatus"), userStatus)

        );
        */

        Assertions.assertAll(
                () -> assertEquals(200, response.getStatusCode()),
                () -> assertEquals("message", response
                        .jsonPath()
                        .getString("message")),
                () -> assertEquals("unknown", response
                        .jsonPath()
                        .getString("type"))
        );
    }

}
