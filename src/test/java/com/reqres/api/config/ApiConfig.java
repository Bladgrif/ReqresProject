package com.reqres.api.config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiConfig {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api/";
    }
}
