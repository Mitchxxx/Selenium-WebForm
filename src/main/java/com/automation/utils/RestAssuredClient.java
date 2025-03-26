package com.automation.utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {
    // HTTP GET Method
    public Response get (String endpoint) {
        return given().when()
                .get(endpoint)
                .then().extract().response();
    }

    // HTTP POST Method

    public Response post (String uri, String endpoint, String objectBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(objectBody)
                .when()
                .post(endpoint)
                .then().extract().response();
    }

    // HTTP PUT Method
    public Response put (String uri, String endpoint, String objectBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(objectBody)
                .when()
                .put(endpoint)
                .then().extract().response();
    }

    // HTTP DELETE method
    public Response delete(String uri, String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

}
