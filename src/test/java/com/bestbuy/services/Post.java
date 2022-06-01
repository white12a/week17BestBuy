package com.bestbuy.services;

import com.bestbuy.model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {

    @Test
    public void postName(){
        ServicesPojo servicesPojo=new ServicesPojo();
        servicesPojo.setName("lap tap");

        Response response= given()
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
