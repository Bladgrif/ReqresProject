package com.reqres.api.tests;

import com.reqres.api.config.ApiConfig;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class UserTests extends ApiConfig {

    @Test
    void testGetUsers() {
        given()
                .when()
                .get("users?page=2")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data",hasSize(greaterThan(0)));
    }
}
