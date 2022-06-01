package com.bestbuy.utilities;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HealthCheck extends TestBase {

    @Test
    public void healthCheck(){
        Response response= given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
