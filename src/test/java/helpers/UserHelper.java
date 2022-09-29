package helpers;

import client.RestAssuredClient;
import config.APIConstants;
import io.restassured.response.Response;
import models.request.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserHelper extends RestAssuredClient {

    public UserHelper() {
        super(APIConstants.PetStore.BASE_URL);
    }

    //public CreateUserResponse createUserResponse() {}

    /**
     * Method to create a new user with array
     */
    //public Response createUserWithArray() {}

    /**
     * Method to create a new user with list
     */
    //public Response createUserWithList() {}

    /**
     * Method to create User
     *
     * @param id
     * @param username
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param phone
     * @param userStatus
     * @return
     */
    public Response createUser(Integer id, String username, String firstName, String lastName, String email, String password, Integer phone, String userStatus) {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .id(id)
                .username(username)
                .firstname(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
        return post("user", createUserRequest);
    }


    /**
     * Method to get user using username
     *
     * @param username
     * @return
     */
    public Response getUser(String username) {
        return get("user/" + username);
    }

    /**
     * Method to delete user using username. This method is possible only if user is logged in.
     *
     * @param username
     * @return
     */
    public Response deleteUser(String username) {
        return delete("user/" + username);
    }

    /**
     * Method to update user using username.This method is possible only if user is logged in.
     *
     * @param username
     * @return
     */
    public Response updateUser(Integer id, String username, String firstName, String lastName, String email, String password, Integer phone, String userStatus) {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .id(id)
                .username(username)
                .firstname(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
        return put("user/" + username, createUserRequest);
    }

    /**
     * Method to login user using username and password.
     *
     * @param username
     * @param password
     * @return
     */
    public Response loginUser(String username, String password) {
        return given()
                .queryParam("username", username, "password", password)
                .get("user/login");
    }

    /**
     * Method to logout current logged-in user session.
     *
     * @return
     */
    public Response logoutUser() {
        return get("user/logout");
    }
}
