package com.myown.luckynumbers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
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

    @Test
    void sixUpToSixtyThreeTimes() {
        given()
            .when().get("/gen/6upto60/10")
            .then().statusCode(200)
                .body(notNullValue());
    }

    @Test
    void sixUpToSixtyWithGivenNumbers() {
        given()
                .when().get("/gen/6upto60/with/2,6")
                .then().statusCode(200)
                .body(notNullValue());
    }

    @Test
    void sixUpToSixtyWithNegativeGivenNumberMustFail() {
        given()
                .when().get("/gen/6upto60/with/-7")
                .then().statusCode(400)
                .body(containsString("Numbers must be greater than zero"));
    }

}