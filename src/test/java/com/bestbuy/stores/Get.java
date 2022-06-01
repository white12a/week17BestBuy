package com.bestbuy.stores;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {

    @Test
    public void getUsers() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
