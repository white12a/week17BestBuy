package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class getId extends TestBase {
    @Test
    public void getUserById(){
        Response response=given()
                .when()
                .get("/products/43900");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
