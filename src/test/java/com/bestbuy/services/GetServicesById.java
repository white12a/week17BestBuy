package com.bestbuy.services;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetServicesById extends TestBase {

    @Test
    public void getServiceById(){
        Response response= given()
                .header("Content-Type","application/json")
                .when()
                .get("/services/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
