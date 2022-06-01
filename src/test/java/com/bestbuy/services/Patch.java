package com.bestbuy.services;

import com.bestbuy.model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {

    @Test
    public void updateName(){
        ServicesPojo servicesPojo= new ServicesPojo();
        servicesPojo.setName("Apple iphones");

        Response response= given()
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .when()
                .patch("/services/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
