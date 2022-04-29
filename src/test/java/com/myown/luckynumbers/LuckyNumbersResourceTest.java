package com.myown.luckynumbers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class LuckyNumbersResourceTest {

    @Test
    void sixUpToSixty() {
        given()
            .when().get("/gen/6upto60")
            .then().statusCode(200)
                .body(notNullValue());
    }

}