package com.reqres.api.tests;

import com.reqres.api.config.ApiConfig;
import com.reqres.api.models.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void checkUserAndId() {
        List<UserData> users= given()
                .when()
                .contentType(ContentType.JSON)
                .get("users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        for (UserData u : users) {
            System.out.println(u.getId() + " " + u.getAvatar());
        }

    }
}
