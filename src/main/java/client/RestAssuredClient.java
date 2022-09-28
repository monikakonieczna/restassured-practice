package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Class includes general Rest Assured api call methods (HTTP Methods: Get, Post, Put, Patch, Delete)
 * to avoid retyping the same codes in step classes or helper classes.
 */
public abstract class RestAssuredClient {

    String baseUrl;

    public RestAssuredClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response get(String path) {
        RequestSpecification httpRequest = RestAssured
                .given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        return httpRequest.get(path);
    }

    public Response post(String path, Object body) {
        RequestSpecification httpRequest = RestAssured
                .given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest
                .header("Content-Type", "application/json")
                .body(body);
        return httpRequest.post(path);
    }

    public Response delete(String path) {
        RequestSpecification httpRequest = RestAssured
                .given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest
                .header("api_key","special-key");
        return httpRequest.delete(path);
    }

    public Response put(String path, Object body) {
        RequestSpecification httpRequest = RestAssured
                .given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest
                .header("Content-Type", "application/json")
                .body(body);
        return httpRequest.put(path);
    }

    public Response patch(String path, Object body) {
        RequestSpecification httpRequest = RestAssured
                .given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest
                .header("Content-Type", "application/json")
                .body(body);
        return httpRequest.patch(path);
    }

}
