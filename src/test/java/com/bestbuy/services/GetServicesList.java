package com.bestbuy.services;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetServicesList extends TestBase {

    @Test
    public void getServicesList(){
        Response response= given()
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
